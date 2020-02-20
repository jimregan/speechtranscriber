package io.github.jimregan.speechtranscriber.abair.corpus;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
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
    public void loadXML(InputSource is) throws Exception {
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
        NodeList nl = doc.getDocumentElement().getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            if(n.getNodeName().equals("sentence")) {
                addSentence(Sentence.fromXML(n));
            } else if(canSkipNode(n)) {
                // do nothing
            } else {
                throw new IOException("Unexpected node: " + n.getNodeName());
            }
        }
    }
}
