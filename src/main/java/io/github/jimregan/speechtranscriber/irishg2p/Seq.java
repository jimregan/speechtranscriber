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

public class Seq extends G2PPiece {
    G2PPiece[] pieces;
    public Seq(String g, G2PPiece[] pieces) {
        this.grapheme = g;
        this.pieces = pieces;
    }
    public Seq(String g, G2PPiece[] pieces, String context) {
        this(g, pieces);
        this.context = context;
    }
    public G2PPiece[] getPieces() {
        return pieces;
    }
    private static final ShortVowel INSERT_SCHWA = new ShortVowel(null, null, "ə");
    public static Seq insertSchwa(String seqs, String broad, String slender) throws Exception {
        if (!seqs.contains(" ")) {
            throw new Exception("Missing space: " + seqs);
        }
        if (!broad.contains(" ")) {
            throw new Exception("Missing space: " + broad);
        }
        if (!slender.contains(" ")) {
            throw new Exception("Missing space: " + slender);
        }
        String[] aseqs = seqs.split(" ");
        String[] abroad = broad.split(" ");
        String[] aslender = slender.split(" ");
        if (aseqs.length != 2) {
            throw new Exception("Too many spaces: " + seqs);
        }
        if (abroad.length != 2) {
            throw new Exception("Too many spaces: " + broad);
        }
        if (aslender.length != 2) {
            throw new Exception("Too many spaces: " + slender);
        }
        String g = aseqs[0] + aseqs[1];
        return new Seq(g, new G2PPiece[]{
                new Consonant(aseqs[0], abroad[0], aslender[0]),
                INSERT_SCHWA,
                new Consonant(aseqs[1], abroad[1], aslender[1]),
        });
    }
}
