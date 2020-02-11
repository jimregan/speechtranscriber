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
package io.github.jimregan.speechtranscriber.segment;

import net.loomchild.segment.TextIterator;
import net.loomchild.segment.srx.SrxDocument;
import net.loomchild.segment.srx.SrxParser;
import net.loomchild.segment.srx.SrxTextIterator;
import net.loomchild.segment.srx.io.Srx2Parser;
import net.loomchild.segment.util.Util;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class SRXSentence {
    private SrxDocument document;
    private String language;

    public SRXSentence(String language) throws IOException {
        this.language = language;
        if(language.equals("pl")) {
            loadPolishSRX();
        } else {
            throw new IOException("No pre-configured SRX for language: " + language);
        }
    }

    public static String readAll(String filename) {
        Reader r = Util.getReader(Util.getFileInputStream(filename));
        return Util.readAll(r);
    }

    private static final String POLISH_SRX = "io/github/jimregan/speechtranscriber/polish_srx_rules/polish.srx";
    void loadSRXResource(String filename) throws IOException {
        Reader reader = Util.getReader(Util.getResourceStream(filename));
        SrxParser parser = new Srx2Parser();
        this.document = parser.parse(reader);
        reader.close();
    }
    private void loadPolishSRX() throws IOException {
        this.loadSRXResource(POLISH_SRX);
    }

    String[] getSegments(String[] pieces, boolean merge) {
        List<String> segments = new ArrayList<>();
        if(merge) {
            String merged = String.join("\n", pieces);
            TextIterator textit = new SrxTextIterator(this.document, this.language, merged);
            while(textit.hasNext()) {
                segments.add(textit.next());
            }
        } else {
            for(String piece : pieces) {
                TextIterator textit = new SrxTextIterator(this.document, this.language, piece);
                while(textit.hasNext()) {
                    segments.add(textit.next());
                }
            }
        }
        return segments.toArray(new String[segments.size()]);
    }
}
