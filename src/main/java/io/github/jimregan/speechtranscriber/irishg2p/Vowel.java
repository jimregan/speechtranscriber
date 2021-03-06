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

public abstract class Vowel extends G2PPiece {
    String stressedPhoneme;
    String unstressed = null;
    public boolean startSlender() {
        return Tools.startsSlenderVowel(this.getGrapheme());
    }
    public boolean endsSlender() {
        return Tools.endsSlenderVowel(this.getGrapheme());
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
    @Override
    String[][] getPhonemes () {
        List<String[]> out = new ArrayList<String[]>();
        if(getStressed() != null) {
            out.add(getStressed());
        }
        if(getUnstressed() != null) {
            out.add(getUnstressed());
        }
        return out.toArray(new String[out.size()][]);
    }
}
