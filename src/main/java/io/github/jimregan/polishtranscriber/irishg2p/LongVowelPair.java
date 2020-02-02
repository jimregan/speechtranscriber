package io.github.jimregan.polishtranscriber.irishg2p;

public class LongVowelPair extends Vowel {
    private Seq vowelSeq;
    public LongVowelPair() {}
    public LongVowelPair(String g, String stressed) throws Exception {
        if (!g.contains(" ")) {
            throw new Exception("Missing space: " + g);
        }
        if (!stressed.contains(" ")) {
            throw new Exception("Missing space: " + stressed);
        }
        String[] aseqs = g.split(" ");
        String[] along = stressed.split(" ");
        if (aseqs.length != 2) {
            throw new Exception("Too many spaces: " + g);
        }
        if (along.length != 2) {
            throw new Exception("Too many spaces: " + stressed);
        }
        this.grapheme = aseqs[0] + aseqs[1];
        this.vowelSeq = new Seq(g, new G2PPiece[]{
                new LongVowel(aseqs[0], null, along[0]),
                new LongVowel(aseqs[1], null, along[1])
        });
    }
    @Override
    public boolean isLong() {
        return true;
    }
}
