/*
 * Copyright 2020 Jim O'Regan <jaoregan@tcd.ie>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */
package io.github.jimregan.speechtranscriber.irishg2p;

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
