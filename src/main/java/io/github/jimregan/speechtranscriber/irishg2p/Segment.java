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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Segment {
    public static List<G2PPiece> segment(Entry e, Map<String, List<G2PPiece>> map) throws Exception {
        List<G2PPiece> out = new ArrayList<>();
        String in = e.getWord();
        Pattern p = Pattern.compile("^" + Utils.buildRegex(map) + ".*$");
        for (int i = 0, j = 0; i < in.length() && j < e.getPhones().length; i++, j++) {
            Matcher m = p.matcher(in.substring(i));
            if(!m.matches()) {
                throw new Exception("No match: " + in.substring(i));
            }
            if(m.groupCount() != 1) {
                throw new Exception("Wrong .groupCount(): " + m.groupCount());
            }
            String key = m.group(1);
            boolean matched = false;
            int offset = 0;
            while(!matched && !key.equals("")) {
                if(key.length() == 1 && !map.containsKey(key)) {
                    throw new Exception("No key for " + key + " (" + in + ")");
                }
                if(!map.containsKey(key)) {
                    Matcher m2 = p.matcher(key.substring(0, key.length() - 1));
                    key = m2.group(1);
                    continue;
                }
                int ext = key.length();
                List<G2PPiece> cur = map.get(key);
                for (G2PPiece piece : cur) {
                    String[][] phones = piece.getPhonemes();
                    if (!Utils.checkContext(piece, in.substring(i), offset)) {
                        continue;
                    }
                    for (String[] phoneset : phones) {
                        if(Utils.arrayEquals(phoneset, e.getPhones(), j)) {
                            out.add(piece);
                            matched = true;
                            if(ext > 0) {
                                i += ext - 1;
                            }
                            j += (phoneset.length > 1) ? phoneset.length - 1 : 0;
                            //j += phoneset.length - 1;
                        }
                    }
                }
            }
        }
        return out;
    }

}
