/*
 * Copyright 2020 Jim O'Regan <jaoregan@tcd.ie>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */
package io.github.jimregan.speechtranscriber.irishg2p;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void testStartsSlenderVowel() {
        assertEquals(false, Utils.startsSlenderVowel("a"));
        assertEquals(true, Utils.startsSlenderVowel("ea"));
    }

    @Test
    public void testEndsSlenderVowel() {
        assertEquals(false, Utils.endsSlenderVowel("ae"));
        assertEquals(true, Utils.endsSlenderVowel("e"));
        assertEquals(true, Utils.endsSlenderVowel("blé"));
    }

    @Test
    public void testArrayEquals() {
        String[] a = new String[]{"a", "b"};
        String[] b = new String[]{"a", "b", "c"};
        assertEquals(true, Utils.arrayEquals(a, b));
        String[] c = new String[]{"a", "b"};
        String[] d = new String[]{"x", "y", "a", "b", "c"};
        assertEquals(true, Utils.arrayEquals(c, d, 2));
    }

    @Test
    public void testCheckContext() throws Exception {
        Consonant mb = new Consonant("mb", "mˠ", "mʲ", "^");
        Consonant mb1 = new Consonant("mb", "mˠ", "mʲ");
        String t1 = "mbosca";
        assertEquals(mb.makeMatchString(), "^(mb).*");
        assertTrue(t1.matches("^(mb).*"));
        assertTrue(Utils.checkContext(mb, t1, 0));
        String t2 = "ambosca";
        assertFalse(Utils.checkContext(mb, t1, 1));
    }
}