package io.github.jimregan.polishtranscriber.irishg2p;

public class ShortVowel extends Vowel {
    String unstressed = "ə";
    public ShortVowel(String g, String p) {
        this.grapheme = g;
        this.stressedPhoneme = p;
    }
    public ShortVowel(String g, String p, String unstressed) {
        this(g, p);
        this.unstressed = unstressed;
    }
    String[] getUnstressed() {
        return unstressed.split(" ");
    }
    String[] getStressed() {
        return stressedPhoneme.split(" ");
    }
    @Override
    String[][] getPhonemes () {
        String[][] out = new String[2][];
        out[0] = getStressed();
        out[1] = getUnstressed();
        return out;
    }
}
