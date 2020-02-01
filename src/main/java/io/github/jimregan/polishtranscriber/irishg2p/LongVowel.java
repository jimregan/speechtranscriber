package io.github.jimregan.polishtranscriber.irishg2p;

public class LongVowel extends Vowel {
    public LongVowel(String g, String p) {
        this.grapheme = g;
        this.stressedPhoneme = p;
    }
    public LongVowel(String g, String p, String context) {
        this(g, p);
        this.setContext(context);
    }
}
