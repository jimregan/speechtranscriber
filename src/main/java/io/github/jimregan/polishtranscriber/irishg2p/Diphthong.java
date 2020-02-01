package io.github.jimregan.polishtranscriber.irishg2p;

public class Diphthong extends Vowel {
    public Diphthong(String g, String p) {
        this.grapheme = g;
        this.stressedPhoneme = p;
        this.unstressed = "ə";
    }
    public Diphthong(String g, String p, String unstressed) {
        this(g, p);
        this.unstressed = unstressed;
    }
}
