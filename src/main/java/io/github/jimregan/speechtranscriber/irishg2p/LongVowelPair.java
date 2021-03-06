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

public class LongVowelPair extends Vowel {
    private Seq vowelSeq;
    public LongVowelPair() {}
    public LongVowelPair(String g, String stressed) throws Exception {
        if (!g.contains(" ")) {
            throw new Exception("Missing space: " + g);
        }
        if (!stressed.contains(" ")) {
            throw new Exception("Missing space: " + stressed);
        }
        String[] aseqs = g.split(" ");
        String[] along = stressed.split(" ");
        if (aseqs.length != 2) {
            throw new Exception("Too many spaces: " + g);
        }
        if (along.length != 2) {
            throw new Exception("Too many spaces: " + stressed);
        }
        this.grapheme = aseqs[0] + aseqs[1];
        this.vowelSeq = new Seq(g, new G2PPiece[]{
                new LongVowel(aseqs[0], null, along[0]),
                new LongVowel(aseqs[1], null, along[1])
        });
    }
    @Override
    public boolean isLong() {
        return true;
    }
}
