package io.github.jimregan.polishtranscriber.irishg2p;

public class Seq extends G2PPiece {
    G2PPiece[] pieces;
    public Seq(String g, G2PPiece[] pieces) {
        this.grapheme = g;
        this.pieces = pieces;
    }
    public Seq(String g, G2PPiece[] pieces, String context) {
        this(g, pieces);
        this.context = context;
    }
}
