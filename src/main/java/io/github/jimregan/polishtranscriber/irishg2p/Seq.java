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
    public G2PPiece[] getPieces() {
        return pieces;
    }
    private static final ShortVowel INSERT_SCHWA = new ShortVowel(null, null, "ə");
    public static Seq insertSchwa(String seqs, String broad, String slender) throws Exception {
        if (!seqs.contains(" ")) {
            throw new Exception("Missing space: " + seqs);
        }
        if (!broad.contains(" ")) {
            throw new Exception("Missing space: " + broad);
        }
        if (!slender.contains(" ")) {
            throw new Exception("Missing space: " + slender);
        }
        String[] aseqs = seqs.split(" ");
        String[] abroad = broad.split(" ");
        String[] aslender = slender.split(" ");
        if (aseqs.length != 2) {
            throw new Exception("Too many spaces: " + seqs);
        }
        if (abroad.length != 2) {
            throw new Exception("Too many spaces: " + broad);
        }
        if (aslender.length != 2) {
            throw new Exception("Too many spaces: " + slender);
        }
        String g = aseqs[0] + aseqs[1];
        return new Seq(g, new G2PPiece[]{
                new Consonant(aseqs[0], abroad[0], aslender[0]),
                INSERT_SCHWA,
                new Consonant(aseqs[1], abroad[1], aslender[1]),
        });
    }
}
