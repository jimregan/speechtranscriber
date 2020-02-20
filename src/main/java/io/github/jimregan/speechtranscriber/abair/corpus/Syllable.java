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

public class Syllable {
    int stress;
    private String raw_stress = null;
    List<Phoneme> phonemes;
    public Syllable() {
        this.phonemes = new ArrayList<>();
    }
    public Syllable(String stress) {
        this();
        this.raw_stress = stress;
        if(stress.matches("^[012]$")) {
            this.stress = Integer.parseInt(stress);
        } else {
            this.stress = 0;
        }
    }

    public int getStress() {
        return stress;
    }
    public void setStress(int stress) {
        this.stress = stress;
    }
    public List<Phoneme> getPhonemes() {
        return phonemes;
    }
    public void setPhonemes(List<Phoneme> phonemes) {
        this.phonemes = phonemes;
    }

    public static Syllable fromXML(Node n) throws Exception {
        List<Phoneme> phonemes = new ArrayList<>();
        if (n.getNodeName().equals("syllable")) {
            String stress = XML.attrib(n, "stress", false);
            Syllable out = new Syllable(stress);
            for (int i = 0; i < n.getChildNodes().getLength(); i++) {
                Node ch = n.getChildNodes().item(i);
                if (ch.getNodeName().equals("phoneme")) {
                    phonemes.add(Phoneme.fromXML(ch));
                } else if (XML.canSkipNode(ch)) {
                    // skip
                } else {
                    throw new Exception("Unexpected child node: " + ch.getNodeName());
                }
            }
            out.setPhonemes(phonemes);
            return out;
        } else {
            throw new Exception("Node does not contain syllable");
        }
    }
}
