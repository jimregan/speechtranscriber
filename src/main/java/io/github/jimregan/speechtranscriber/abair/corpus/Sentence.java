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
    public static Sentence fromXML(Node n) {
        Sentence out = new Sentence();

        return out;
    }
}
