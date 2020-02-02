package io.github.jimregan.polishtranscriber.irishg2p;

import java.util.List;

public abstract class G2PPiece {
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
    private String makeMatchString() throws Exception {
        if (!hasContext()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (this.getContext().startsWith("^")) {
            sb.append(this.getContext());
            sb.append('(');
            sb.append(this.getGrapheme());
            sb.append(')');
        } else if (this.getContext().endsWith("$")) {
            sb.append('(');
            sb.append(this.getGrapheme());
            sb.append(')');
            sb.append(this.getContext());
        } else if (this.getContext().contains("_")) {
            String[] parts = getContext().split("_");
            if (parts.length != 2) {
                throw new Exception("Context has more than one instance of grapheme");
            }
            sb.append(parts[0]);
            sb.append('(');
            sb.append(this.getGrapheme());
            sb.append(')');
            sb.append(parts[1]);
        }
        return getContext();
    }
    public boolean hasUnstressedSequence() {
        return false;
    }
    public boolean isConsonant() {
        return !isVowel();
    }
    public boolean isVowel() {
        return false;
    }
    public boolean isLong() {
        return false;
    }
}
