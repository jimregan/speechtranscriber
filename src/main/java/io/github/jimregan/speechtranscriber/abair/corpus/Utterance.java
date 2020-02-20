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

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Utterance {
    String inputString;
    List<Sentence> sentences;
    public Utterance() {
        this.sentences = new ArrayList<>();
    }
    public Utterance(String input) {
        this();
        this.inputString = input;
    }
    public void addSentence(Sentence s) {
        this.sentences.add(s);
    }

    public static Utterance loadXML(InputSource is) throws Exception {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(is);
        String root = doc.getDocumentElement().getNodeName();
        if (!root.equals("utterance")) {
            throw new IOException("Root node is not \"utterance\": have you passed the correct file?");
        }
        String input = null;
        if (doc.getDocumentElement().hasAttribute("input_string")) {
            input = doc.getDocumentElement().getAttribute("input_string");
        }
        if (input == null && doc.getDocumentElement().hasAttribute("string")) {
            input = doc.getDocumentElement().getAttribute("string");
        }
        Utterance out = new Utterance(input);
        NodeList nl = doc.getDocumentElement().getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            if(n.getNodeName().equals("sentence")) {
                out.addSentence(Sentence.fromXML(n));
            } else if(XML.canSkipNode(n)) {
                // do nothing
            } else {
                throw new IOException("Unexpected node: " + n.getNodeName());
            }
        }
        return out;
    }
    public static Utterance loadXML(InputStream is) throws Exception {
        return loadXML(new InputSource(is));
    }
    public static Utterance loadXML(File f) throws Exception {
        return loadXML(new FileInputStream(f));
    }
    public static Utterance loadXML(String filename) throws Exception {
        return loadXML(new File(filename));
    }
}
