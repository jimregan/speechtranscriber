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
package io.github.jimregan.speechtranscriber.preproc.polish.wolne_lektury;

import java.util.ArrayList;
import java.util.List;

public class Interjections {
    static String procInterjections(String s) {
        if(s.matches("^aa+$")) {
            return "aa";
        } else if(s.matches("^ee+$")) {
            return "ee";
        //} else if(s.matches("^ii+$")) {
        //    return "ii";
        } else if(s.matches("^oo+$")) {
            return "oo";
        } else if(s.matches("^uu+$")) {
            return "uu";
        } else if(s.matches("^yy+$")) {
            return "yy";
        } else if(s.matches("^y+m+$")) {
            return "yym";
        } else if(s.matches("^he+j$")) {
            return "hej";
        } else if(s.matches("^hm+$")) {
            return "hm";
        } else {
            return s;
        }
    }
    public static String[] proc(String[] lines) {
        List<String> out = new ArrayList<>();
        for(String line : lines) {
            out.add(proc(line));
        }
        return out.toArray(new String[0]);
    }
    public static String proc(String line) {
        String[] words = line.split(" ");
        List<String> words_out = new ArrayList<>();
        for(String word : words) {
            words_out.add(procInterjections(word));
        }
        return String.join(" ", words_out);
    }
}
