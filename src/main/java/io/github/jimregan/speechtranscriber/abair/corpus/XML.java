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

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.IOException;

public class XML {
    public static boolean canSkipNode(Node n) {
        if(n.getNodeName().equals("#text") && n.getTextContent().trim().equals("")) {
            return true;
        } else if(n.getNodeType() == Element.COMMENT_NODE) {
            return true;
        } else if(n.getNodeType() == Element.PROCESSING_INSTRUCTION_NODE) {
            return true;
        } else if(n.getNodeType() == Element.ELEMENT_NODE) {
            return false;
        } else {
            return false;
        }
    }

    public static String attrib(Node n, String attrib, boolean required) throws Exception {
        if(n.getAttributes() == null || n.getAttributes().getLength() == 0) {
            throw new IOException("Missing required attributes in node " + n.getNodeName());
        }
        if(n.getAttributes().getNamedItem(attrib) != null) {
            return n.getAttributes().getNamedItem(attrib).getTextContent();
        } else {
            if(required) {
                throw new IOException("Required attribute \"" + attrib + "\" missing in node " + n.getNodeName());
            } else {
                return null;
            }
        }
    }
}
