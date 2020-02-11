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
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertArrayEquals;

public class ReadVTTFullTest {

    @Test
    public void testCleanBuffer() {
        byte[] b1 = new byte[]{0, 0, 0};
        byte[] exp1 = new byte[]{(byte) 0xEF, (byte) 0xBF, (byte) 0xBD, (byte) 0xEF, (byte) 0xBF, (byte) 0xBD, (byte) 0xEF, (byte) 0xBF, (byte) 0xBD};
        assertArrayEquals(exp1, ReadVTTFull.cleanBuffer(b1));
        assertArrayEquals(exp1, "\uFFFD\uFFFD\uFFFD".getBytes(StandardCharsets.UTF_8));
        byte[] bom = new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF, (byte) 0x57};
        byte[] bomexp = ReadVTTFull.cleanBuffer(bom);
        assertArrayEquals(new byte[]{0x57}, bomexp);
    }
}