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
    String transSource;
    String transOutputFormat;
    String postlex;
    String origTrans;
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

    public String getTransSource() {
        return transSource;
    }

    public void setTransSource(String transSource) {
        this.transSource = transSource;
    }

    public String getTransOutputFormat() {
        return transOutputFormat;
    }

    public void setTransOutputFormat(String transOutputFormat) {
        this.transOutputFormat = transOutputFormat;
    }

    public String getPostlex() {
        return postlex;
    }

    public void setPostlex(String postlex) {
        this.postlex = postlex;
    }

    public String getOrigTrans() {
        return origTrans;
    }

    public void setOrigTrans(String origTrans) {
        this.origTrans = origTrans;
    }

    public boolean isGenerated() {
        return this.transSource.equals("LTS++");
    }
    public boolean isFullyTimed() {
        if(this.syllables == null || this.syllables.isEmpty()) {
            return false;
        }
        for(Syllable s : syllables) {
            if(!s.isFullyTimed()) {
                return false;
            }
        }
        return true;
    }
    public boolean lastIsTimed() {
        if(this.syllables == null || this.syllables.isEmpty()) {
            return false;
        }
        return this.syllables.get(this.syllables.size() - 1).lastIsTimed();
    }

    public static Word fromXML(Node n) throws Exception {
        List<Syllable> syllables = new ArrayList<>();
        if (n.getNodeName().equals("word")) {
            String input = XML.attrib(n, "input_string", true);
            String trSrc = XML.attrib(n, "trans_source", false);
            String postlex = XML.attrib(n, "postlex", false);
            String trOut = XML.attrib(n, "trans_output_format", false);
            String origTr = XML.attrib(n, "original_transcription", false);

            Word out = new Word(input);
            if(trSrc != null) {
                out.setTransSource(trSrc);
            }
            if(postlex != null) {
                out.setPostlex(postlex);
            }
            if(trOut != null) {
                out.setTransOutputFormat(trOut);
            }
            if(origTr != null) {
                out.setOrigTrans(origTr);
            }
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

