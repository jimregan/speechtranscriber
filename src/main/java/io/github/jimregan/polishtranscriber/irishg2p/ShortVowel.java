package io.github.jimregan.polishtranscriber.irishg2p;

import java.util.ArrayList;
import java.util.List;

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
        List<String[]> out = new ArrayList<String[]>();
        if(getUnstressed() != null) {
            out.add(getStressed());
        }
        if(getStressed() != null) {
            out.add(getStressed());
        }
        return out.toArray(new String[out.size()][]);
    }
}
