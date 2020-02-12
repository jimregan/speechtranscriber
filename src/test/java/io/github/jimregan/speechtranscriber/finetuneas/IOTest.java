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
package io.github.jimregan.speechtranscriber.finetuneas;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class IOTest {

    String sample = "{\"fragments\": [\n" +
            "  {\n" +
            "   \"begin\": \"0.050\",\n" +
            "   \"end\": \"1.490\",\n" +
            "   \"id\": \"f000001\",\n" +
            "   \"language\": \"ga\",\n" +
            "   \"lines\": [\n" +
            "    \"line 1\"\n" +
            "   ]\n" +
            "  }, \n" +
            "  {\n" +
            "   \"begin\": \"1.510\",\n" +
            "   \"end\": \"2.010\",\n" +
            "   \"id\": \"f000002\",\n" +
            "   \"language\": \"ga\",\n" +
            "   \"lines\": [\n" +
            "    \"Second line,\"\n" +
            "   ]\n" +
            "  }\n" +
            " ]\n" +
            "}";
    @Test
    public void testFromString() throws Exception {
        List<Fragment> fragments = IO.fromString(sample);
        assertEquals(2, fragments.size());
        Fragment f = fragments.get(0);
        Fragment f1 = fragments.get(1);
        assertFalse(f == null);
        assertEquals("1.510", f1.getStart());
        assertEquals(1, f1.getLines().size());
        assertEquals("Second line,", f1.getLines().get(0));
    }
}