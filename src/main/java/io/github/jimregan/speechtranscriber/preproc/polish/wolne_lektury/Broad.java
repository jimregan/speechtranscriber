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

import io.github.jimregan.speechtranscriber.PolishNumbers;
import io.github.jimregan.speechtranscriber.Roman;
import io.github.jimregan.speechtranscriber.Utils;

import java.util.ArrayList;
import java.util.List;

public class Broad {
    public static String[] proc(String[] in) {
        List<String> out = new ArrayList<>();
        for (String line : in) {
            if (line.equals("E. T. A. Hoffmann")) {
                out.add("Ernst Teodor Amadeusz Hoffmann");
            } else if (line.toLowerCase().startsWith("rozdział ")) {
                StringBuilder sb = new StringBuilder();
                sb.append(line.substring(0, 9));
                String rest = line.substring(9);
                rest = Utils.trim(rest);
                if(Roman.isValid(rest)) {
                    sb.append(PolishNumbers.romanToOrdinal(rest));
                }
                out.add(sb.toString());
            } else if (line.toLowerCase().startsWith("pieśń ")) {
                StringBuilder sb = new StringBuilder();
                sb.append(line.substring(0, 6));
                String rest = line.substring(6);
                rest = Utils.trim(rest);
                if(Roman.isValid(rest)) {
                    sb.append(PolishNumbers.romanToOrdinal(rest, "f"));
                }
                out.add(sb.toString());
            } else if (line.startsWith("ISBN")) {
                continue;
            } else if (line.equals("-----")) {
                break;
            } else {
                out.add(line);
            }

        }
        return out.toArray(new String[out.size()]);
    }
}
