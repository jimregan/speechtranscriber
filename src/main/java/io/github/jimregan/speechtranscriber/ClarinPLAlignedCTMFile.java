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
package io.github.jimregan.speechtranscriber;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClarinPLAlignedCTMFile {
    List<CTMTimedWord> words;
    public ClarinPLAlignedCTMFile() {
        this.words = new ArrayList<>();
    }
    public ClarinPLAlignedCTMFile(String filename) throws IOException {
        this.words = fromFile(filename);
    }
    public String[] toStrings() {
        List<String> out = new ArrayList<>();
        for(CTMTimedWord w : words) {
            out.add(w.getText());
        }
        return out.toArray(new String[0]);
    }
    public static List<CTMTimedWord> fromFile(String filename) throws IOException {
        String lines[] = Utils.readTextLines(filename);
        List<CTMTimedWord> out = new ArrayList<>();
        int line_no = 0;
        List<CTMTimedItem> pron = new ArrayList<>();
        for(String line : lines) {
            line_no++;

            if(line.equals("")) {
                continue;
            }
            if(!line.contains(" ")) {
                System.err.println("Error reading line " + line_no + " (" + line + ")");
                continue;
            }

            String[] parts = line.split(" ");
            if(parts.length != 5) {
                System.err.println("Error reading line " + line_no + " (" + line + ")");
                continue;
            }
            if(!checkTime(parts[2]) || !checkTime(parts[3])) {
                System.err.println("Error reading line " + line_no + " (" + line + ")");
                continue;
            }

            if(parts[0].startsWith("@")) {
                if(parts[4].equals("sil")) {
                    out.add(new CTMTimedWord("sil", parts[2], parts[3]));
                } else {
                    pron.add(new CTMTimedItem(parts[4], parts[2], parts[3]));
                }
            } else {
                int last = out.size() - 1;
                if(last > 0 && !pron.isEmpty()) {
                    out.get(last).setPronunciation(pron);
                    pron.clear();
                }
                out.add(new CTMTimedWord(parts[4], parts[2], parts[3]));
            }
        }
        return out;
    }
    private static boolean checkTime(String s) {
        return s.matches("[0-9]+\\.[0-9][0-9][0-9]");
    }
}
