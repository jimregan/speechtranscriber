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

import java.io.IOException;

public class Phoneme {
    String symbol;
    String rawEnd;
    boolean has_end = false;
    public Phoneme(String symbol) {
        this.symbol = symbol;
        this.rawEnd = null;
        this.has_end = false;
    }
    public Phoneme(String symbol, String end) {
        this.symbol = symbol;
        this.rawEnd = end;
        this.has_end = true;
    }
    public static Phoneme fromXML(Node n) throws Exception {
        if(n.getNodeName().equals("phoneme")) {
            String symbol = XML.attrib(n, "symbol", true);
            String end = XML.attrib(n, "end", false);
            if(end != null) {
                return new Phoneme(symbol, end);
            } else {
                return new Phoneme(symbol);
            }
        } else {
            throw new IOException("Node does not contain phoneme");
        }
    }
}
