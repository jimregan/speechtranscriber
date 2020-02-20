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

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class Word {
    List<Syllable> syllables;
    String inputString;
    public Word() {
        this.syllables = new ArrayList<>();
    }
    public Word(String input) {
        this.inputString = input;
    }

    public List<Syllable> getSyllables() {
        return syllables;
    }
    public void setSyllables(List<Syllable> syllables) {
        this.syllables = syllables;
    }
    public String getInputString() {
        return inputString;
    }
    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public static Word fromXML(Node n) throws Exception {
        List<Syllable> syllables = new ArrayList<>();
        if (n.getNodeName().equals("word")) {
            String input = XML.attrib(n, "input_string", true);
            String trSrc = XML.attrib(n, "trans_source", false);
            Word out = new Word(input);
            for (int i = 0; i < n.getChildNodes().getLength(); i++) {
                Node ch = n.getChildNodes().item(i);
                if (ch.getNodeName().equals("syllable")) {
                    syllables.add(Syllable.fromXML(ch));
                } else if (XML.canSkipNode(ch)) {
                    // skip
                } else {
                    throw new Exception("Unexpected child node: " + ch.getNodeName());
                }
            }
            out.setSyllables(syllables);
            return out;
        } else {
            throw new Exception("Node does not contain word");
        }
    }

}

