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
package io.github.jimregan.speechtranscriber.subtitles;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SimpleTimeTest {

    SimpleTime t1 = new SimpleTime(1, 5, 32, 101);
    SimpleTime t2 = new SimpleTime(21, 14, 23, 11);

    @Test
    public void testGetMilliseconds() {
        assertEquals(3_932_101, t1.getMilliseconds());
    }

    public void testFromString() throws IOException {
        SimpleTime st1 = SimpleTime.fromString("01:05:32.101");
        assertEquals(1, st1.hours);
        assertEquals(5, st1.minutes);
        assertEquals(32, st1.seconds);
        assertEquals(101, st1.millis);
        SimpleTime st2 = SimpleTime.fromString("21:14:23,011");
        assertEquals(21, st2.hours);
        assertEquals(14, st2.minutes);
        assertEquals(23, st2.seconds);
        assertEquals(11, st2.millis);
    }
    @Test(expected = IOException.class)
    public void testFromString1() throws IOException {
        SimpleTime.fromString("21:14:23:011");
    }

    @Test
    public void testGetSeconds() {
        assertEquals(3_932, t1.getSeconds());
    }

    @Test
    public void testToVTTString() {
        assertEquals("21:14:23.011", t2.toVTTString());
    }

    @Test
    public void testToSRTString() {
        assertEquals("21:14:23,011", t2.toSRTString());
    }

    @Test
    public void testToFTASString() {
        assertEquals("76463.011", t2.toFTASString());
    }
}