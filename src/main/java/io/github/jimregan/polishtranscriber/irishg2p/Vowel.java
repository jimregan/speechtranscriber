package io.github.jimregan.polishtranscriber.irishg2p;

public abstract class Vowel extends G2PPiece {
    String stressedPhoneme;
    String unstressed = null;
    public boolean startSlender() {
        return Utils.startsSlenderVowel(this.getGrapheme());
    }
    public boolean endsSlender() {
        return Utils.endsSlenderVowel(this.getGrapheme());
    }
    String[] getUnstressed() {
        if (this.unstressed == null) {
            return null;
        } else {
            return unstressed.split(" ");
        }
    }
    String[] getStressed() {
        return stressedPhoneme.split(" ");
    }
    @Override
    public boolean isVowel() {
        return true;
    }
}
