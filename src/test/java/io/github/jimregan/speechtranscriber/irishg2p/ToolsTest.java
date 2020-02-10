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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ToolsTest {

    @Test
    public void testStartsSlenderVowel() {
        assertEquals(false, Tools.startsSlenderVowel("a"));
        assertEquals(true, Tools.startsSlenderVowel("ea"));
    }

    @Test
    public void testEndsSlenderVowel() {
        assertEquals(false, Tools.endsSlenderVowel("ae"));
        assertEquals(true, Tools.endsSlenderVowel("e"));
        assertEquals(true, Tools.endsSlenderVowel("blé"));
    }

    @Test
    public void testArrayEquals() {
        String[] a = new String[]{"a", "b"};
        String[] b = new String[]{"a", "b", "c"};
        assertEquals(true, Tools.arrayEquals(a, b));
        String[] c = new String[]{"a", "b"};
        String[] d = new String[]{"x", "y", "a", "b", "c"};
        assertEquals(true, Tools.arrayEquals(c, d, 2));
    }

    @Test
    public void testCheckContext() throws Exception {
        Consonant mb = new Consonant("mb", "mˠ", "mʲ", "^");
        Consonant mb1 = new Consonant("mb", "mˠ", "mʲ");
        Consonant mb2 = new Consonant("mb", "mˠ", "mʲ", "_o");
        String t1 = "mbosca";
        assertEquals(mb.makeMatchString(), "^(mb).*");
        assertTrue(t1.matches("^(mb).*"));
        assertTrue(Tools.checkContext(mb, t1, 0));
        String t2 = "ambosca";
        assertFalse(Tools.checkContext(mb, t1, 1));
        String t3 = "mbambosca";
        assertTrue(Tools.checkContext(mb2, t3, 3));
    }

    public void testBuildRegex() {
        List<G2PPiece> l = new ArrayList<>();
        Map<String, List<G2PPiece>> tst = new HashMap<>();
        l.add(new Consonant("mb", "mˠ", "mʲ"));
        tst.put("aa", l);
        tst.put("a", l);
        tst.put("aaa", l);
        assertEquals("(aaa|aa|a)", Tools.buildRegex(tst));
        Map<String, String> tst2 = new HashMap<>();
        tst2.put("foo", "bar");
        tst2.put("foobar", "baz");
        assertEquals("(foobar|foo)", Tools.buildRegex(tst2));
    }
}