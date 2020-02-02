package io.github.jimregan.polishtranscriber.irishg2p;

public class Consonant extends G2PPiece {
    String broad;
    String slender;
    boolean is_broad = true;
    boolean broadnessSet = false;
    public Consonant(String g, String broad, String slender) {
        this.grapheme = g;
        this.broad = broad;
        this.slender = slender;
        if (broad == null) {
            this.broadnessSet = true;
            this.is_broad = false;
        }
    }
    public Consonant(String g, String broad, String slender, String context) {
        this(g, broad, slender);
        this.setContext(context);
    }
    @Override
    public boolean isConsonant() {
        return true;
    }
    public void setBroad(boolean broadness) {
        this.broadnessSet = true;
        this.is_broad = broadness;
    }
    public boolean isBroadnessSet() {
        return broadnessSet;
    }
    public boolean isBroad() {
        return this.is_broad;
    }
}
