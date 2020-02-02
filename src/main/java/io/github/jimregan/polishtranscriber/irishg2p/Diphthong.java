package io.github.jimregan.polishtranscriber.irishg2p;

public class Diphthong extends Vowel {
    public Diphthong() {}
    public Diphthong(String g, String p) {
        this.grapheme = g;
        this.stressedPhoneme = p;
        this.unstressed = null;
    }
    public Diphthong(String g, String p, String unstressed) {
        this(g, p);
        this.unstressed = unstressed;
    }
    public Diphthong(String g, String p, String unstressed, String context) {
        this(g, p, unstressed);
        this.context = context;
    }
    @Override
    public boolean isLong() {
        return true;
    }
}
