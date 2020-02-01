package io.github.jimregan.polishtranscriber.irishg2p;

public class ShortVowel extends Vowel {
    public ShortVowel(String g, String p) {
        this.grapheme = g;
        this.stressedPhoneme = p;
        this.unstressed = "ə";
    }
    public ShortVowel(String g, String p, String unstressed) {
        this(g, p);
        this.unstressed = unstressed;
    }
    @Override
    String[][] getPhonemes () {
        String[][] out = new String[2][];
        out[0] = getStressed();
        out[1] = getUnstressed();
        return out;
    }
}
