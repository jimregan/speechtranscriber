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
package io.github.jimregan.speechtranscriber;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class UtilsTest {
    @Test
    public void testTrim() {
        assertEquals("test", Utils.trim("test"));
        assertEquals("test", Utils.trim("test "));
        assertEquals("test", Utils.trim(" test"));
        assertEquals("test", Utils.trim(" test "));
        assertEquals("test", Utils.trim("\t test \t\t"));
    }

    @Test
    public void testGetNumberPlace() {
        assertEquals(6, Utils.getNumberPlace(356, 1));
        assertEquals(5, Utils.getNumberPlace(356, 2));
        assertEquals(3, Utils.getNumberPlace(356, 3));
    }
    @Test
    public void testGetNumberPlaces() {
        assertArrayEquals(new int[]{3, 5, 6}, Utils.getNumberPlaces(356));
        assertArrayEquals(new int[]{3, 5, 6, 3, 5, 6}, Utils.getNumberPlaces(356356));
    }
}