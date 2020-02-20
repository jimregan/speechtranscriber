package io.github.jimregan.speechtranscriber.abair.corpus;

import org.w3c.dom.Node;

public class Phoneme {
    String symbol;
    String rawEnd;
    boolean has_end = false;
    public Phoneme(String symbol) {
        this.symbol = symbol;
        this.rawEnd = null;
        this.has_end = false;
    }
    public static Phoneme fromXML(Node n) {

        return new Phoneme("");
    }
}
