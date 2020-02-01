package io.github.jimregan.polishtranscriber.irishg2p;

import java.util.List;

public class G2PPiece {
    String grapheme;
    String context = null;
    List<List<String>> graphemes;

    String getGrapheme() {
        return grapheme;
    }

    String[][] getPhonemes () {
        return null;
    }

    public String getContext() {
        return context;
    }
    public void setContext(String context) {
        this.context = context;
    }
    public boolean hasContext() {
        return context == null;
    }
}
