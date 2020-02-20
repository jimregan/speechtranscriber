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
package io.github.jimregan.speechtranscriber.abair.corpus;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhonemeTest {

    String ph1 = "<phoneme symbol=\"tj\"/>";
    String ph2 = "<phoneme symbol=\"tj\" end=\"2.5\"/>";

    @Test
    public void testFromXML() throws Exception {
        Phoneme p1 = Phoneme.fromXML(XML.stringToNode(ph1));
        assertEquals("tj", p1.getSymbol());
        assertFalse(p1.hasEnd());
        Phoneme p2 = Phoneme.fromXML(XML.stringToNode(ph2));
        assertEquals("tj", p2.getSymbol());
        assertTrue(p2.hasEnd());
        assertEquals("2.5", p2.getRawEnd());
    }
}