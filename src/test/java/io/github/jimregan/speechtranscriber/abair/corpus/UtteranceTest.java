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

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class UtteranceTest {

    String eg = "<?xml version=\"1.0\" encoding=\"iso-8859-1\" ?>" +
            "<utterance input_string=\"abc abc\">" +
            "<sentence input_string=\"abc abc\">" +
            "<token input_string=\"abc\">" +
            "<word input_string=\"abc\" trans_source=\"LTS++\">" +
            "<syllable stress=\"1\">\n" +
            "<phoneme symbol=\"a\"/>\n" +
            "<phoneme symbol=\"b\"/>\n" +
            "<phoneme symbol=\"c\" end=\"2.0\"/>\n" +
            "</syllable>" +
            "</word>" +
            "</token>" +
            "<token input_string=\"abc\">" +
            "<word input_string=\"abc\" trans_source=\"LTS++\">" +
            "<syllable stress=\"1\">\n" +
            "<phoneme symbol=\"a\"/>\n" +
            "<phoneme symbol=\"b\"/>\n" +
            "<phoneme symbol=\"c\" end=\"2.0\"/>\n" +
            "</syllable>" +
            "</word>" +
            "</token>" +
            "</sentence>" +
            "</utterance>";

    @Test
    public void testLoadXML() throws Exception {
        Utterance u = Utterance.loadXML(new ByteArrayInputStream(eg.getBytes()));
        assertEquals(1, u.getSentences().size());
    }
}