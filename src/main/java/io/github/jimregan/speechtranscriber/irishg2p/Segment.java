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
import java.util.Map;

public class Segment {
    public static List<G2PPiece> segment(Entry e, Map<String, List<G2PPiece>> map) {
        List<G2PPiece> out = new ArrayList<>();
        String in = e.getWord();
        for (int i = 0, j = 0; i < in.length() && j < e.getPhones().length; i++, j++) {
            int ext = 1;
            while ((i + ext + 1) < in.length() && map.containsKey(in.substring(i, i + ext + 1))) {
                ext++;
            }
            String g = in.substring(i, i + ext);
            String curstring = in.substring(i);
            List<G2PPiece> cur = map.get(g);
            for (G2PPiece piece : cur) {
                String[][] phones = piece.getPhonemes();
                if(piece.hasContext()) {
                    if(piece.getContext().startsWith("^") && i != 0) {
                        continue;
                    }
                    if(!curstring.matches(piece.getContext())) {
                        continue;
                    }
                }
                for (String[] phoneset : phones) {
                    for (int ii = 0, ij = j; ii < phoneset.length && ij < e.getPhones().length; ii++, ij++) {
                        if(!phoneset[ii].equals(e.getPhones()[ij])) {
                            continue;
                        }
                    }
                }
            }
        }
        return out;
    }
}
