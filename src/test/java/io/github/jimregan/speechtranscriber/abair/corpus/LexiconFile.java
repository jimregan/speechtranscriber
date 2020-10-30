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
package io.github.jimregan.speechtranscriber.abair.corpus;

import java.util.*;

public class LexiconFile {
    Map<String, Set<String>> lex;
    public LexiconFile() {
        this.lex = new TreeMap<>();
    }
    public void insert(String[] words, String[] phones) throws Exception {
        if(words.length != phones.length) {
            throw new Exception("words and phones do not contain the same number of entries");
        }
        for(int i = 0; i < words.length; i++) {
            if(!lex.containsKey(words[i])) {
                lex.put(words[i], new HashSet<>());
            }
            lex.get(words[i]).add(phones[i]);
        }
    }
    public void writeSphinx() {
        for(String k : lex.keySet()) {
            Set<String> cur = lex.get(k);
            int i = 0;
            for (Iterator<String> it = cur.iterator(); it.hasNext(); i++) {
                System.out.print(k);
                if(i > 0) {
                    System.out.print("(" + i + ") ");
                } else {
                    System.out.print(" ");
                }
                System.out.println(it.next());
            }
        }
    }
}
