package io.github.jimregan.polishtranscriber.irishg2p;

public class Vowel extends G2PPiece {
    String stressedPhoneme;
    public boolean startSlender() {
        return Utils.startsSlenderVowel(this.getGrapheme());
    }
    public boolean endsSlender() {
        return Utils.endsSlenderVowel(this.getGrapheme());
    }
}
