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

import java.util.ArrayList;
import java.util.List;

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
    String[] getBroad() {
        if (this.broad == null) {
            return null;
        }
        return this.broad.split(" ");
    }
    String[] getSlender() {
        if (this.slender == null) {
            return null;
        }
        return this.slender.split(" ");
    }
    @Override
    String[][] getPhonemes () {
        List<String[]> out = new ArrayList<String[]>();
        if(getBroad() != null) {
            out.add(getBroad());
        }
        if(getSlender() != null) {
            out.add(getSlender());
        }
        return out.toArray(new String[out.size()][]);
    }
}
