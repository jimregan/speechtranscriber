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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReadVTTTest {

    String sample = "WEBVTT\n"
            + "1\n00:00:00.060 --> 00:00:02.210\n"
            + "A simple caption\n\n"
            + "2\n00:00:02.220 --> 00:00:03.010\n"
            + "Another simple caption\n";

    @Test
    public void testReadSimpleVTT() throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(sample.getBytes(StandardCharsets.UTF_8));
        List<SimpleTimedObject> l = ReadVTT.readSimpleVTT(bis);
        assertEquals(2, l.size());
        assertEquals("A simple caption", l.get(0).getText()[0]);
    }
}