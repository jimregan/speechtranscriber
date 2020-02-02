package io.github.jimregan.polishtranscriber.irishg2p;

public class MaybeDiphthong extends Diphthong {
    private final Seq unstressedSeq;
    public MaybeDiphthong(String g, String stressed, String unstressed) throws Exception {
        if (!g.contains(" ")) {
            throw new Exception("Missing space: " + g);
        }
        if (!unstressed.contains(" ")) {
            throw new Exception("Missing space: " + unstressed);
        }
        String[] aseqs = g.split(" ");
        String[] aunstressed = unstressed.split(" ");
        if (aseqs.length != 2) {
            throw new Exception("Too many spaces: " + g);
        }
        if (aunstressed.length != 2) {
            throw new Exception("Too many spaces: " + unstressed);
        }
        this.grapheme = aseqs[0] + aseqs[1];
        this.stressedPhoneme = stressed;
        this.unstressedSeq = new Seq(g, new G2PPiece[]{
                new ShortVowel(aseqs[0], null, aunstressed[0]),
                new Consonant(aseqs[1], null, aunstressed[1])
        });
    }
    @Override
    public boolean hasUnstressedSequence() {
        return true;
    }
    @Override
    public boolean isLong() {
        if (hasUnstressedSequence()) {
            return false;
        } else {
            return true;
        }
    }
}
