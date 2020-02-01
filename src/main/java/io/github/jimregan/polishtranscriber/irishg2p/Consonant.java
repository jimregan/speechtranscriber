package io.github.jimregan.polishtranscriber.irishg2p;

public class Consonant extends G2PPiece {
    String broad;
    String slender;
    public Consonant(String g, String broad, String slender) {
        this.grapheme = g;
        this.broad = broad;
        this.slender = slender;
    }
    public Consonant(String g, String broad, String slender, String context) {
        this(g, broad, slender);
        this.setContext(context);
    }
}
