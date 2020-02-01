package io.github.jimregan.polishtranscriber.irishg2p;

import java.util.List;

public class G2PPiece {
    String grapheme;
    String context = null;
    List<List<String>> phonemes;

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
        return context != null;
    }
    private String makeMatchString() {
        if (!hasContext()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (this.context.startsWith("^")) {
            sb.append(this.context);
            sb.append('(');
            sb.append(this.grapheme);
            sb.append(')');
        } else if (this.context.endsWith("$")) {
            sb.append('(');
            sb.append(this.grapheme);
            sb.append(')');
            sb.append(this.context);
        }
        return getContext();
    }
}
