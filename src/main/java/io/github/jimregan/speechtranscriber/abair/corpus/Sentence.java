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

public class Sentence {
    String inputString;
    List<Token> tokens;

    public Sentence() {
        this.tokens = new ArrayList<>();
    }
    public Sentence(String s) {
        this();
        this.inputString = s;
    }

    public String getInputString() {
        return inputString;
    }
    public void setInputString(String inputString) {
        this.inputString = inputString;
    }
    public List<Token> getTokens() {
        return tokens;
    }
    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public boolean isFullyTimed() {
        if(this.tokens == null || this.tokens.isEmpty()) {
            return false;
        }
        for(Token t : tokens) {
            if(!t.isFullyTimed()) {
                return false;
            }
        }
        return true;
    }
    public boolean lastIsTimed() {
        if(this.tokens == null || this.tokens.isEmpty()) {
            return false;
        }
        return this.tokens.get(this.tokens.size() - 1).lastIsTimed();
    }


    public static Sentence fromXML(Node n) throws Exception {
        List<Token> tokens = new ArrayList<>();
        if (n.getNodeName().equals("sentence")) {
            String string_attr = "input_string";
            if(n.getAttributes().getNamedItem("input_string") == null) {
                string_attr = "string";
            }
            String input = XML.attrib(n, string_attr, true);

            Sentence out = new Sentence(input);
            for (int i = 0; i < n.getChildNodes().getLength(); i++) {
                Node ch = n.getChildNodes().item(i);
                if (ch.getNodeName().equals("token")) {
                    tokens.add(Token.fromXML(ch));
                } else if (XML.canSkipNode(ch)) {
                    // skip
                } else {
                    throw new Exception("Unexpected child node: " + ch.getNodeName());
                }
            }
            out.setTokens(tokens);
            return out;
        } else {
            throw new Exception("Node does not contain sentence");
        }
    }
}
