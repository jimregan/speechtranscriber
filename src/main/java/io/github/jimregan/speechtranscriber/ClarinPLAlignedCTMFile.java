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

import java.io.*;
import java.nio.charset.StandardCharsets;
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
    int countWordPhones() {
        int ret = 0;
        for(CTMTimedWord w : words) {
            ret += w.pronunciation.size();
        }
        return ret;
    }
    static String escapeText(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c == '"') {
                sb.append("\"\"");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    void writeTextGrid(String filename) throws IOException {
        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8));
        bw.write("File type = \"ooTextFile\"\n");
        bw.write("Object class = \"TextGrid\"\n\n");
        bw.write("xmin = ");
        double xmin = words.get(0).start / 1000.0;
        bw.write(Double.toString(xmin));
        bw.write("\n");
        bw.write("xmax = ");
        double xmax = words.get(0).start / 1000.0;
        bw.write(Double.toString(xmax));
        bw.write("\n");
        bw.write("tiers? <exists>\n");
        bw.write("size = 2\n");
        bw.write("item []:\n");
        bw.write("    item [1]:\n");
        bw.write("       class = \"IntervalTier\"\n");
        bw.write("       name = \"words\"\n");
        bw.write("       xmin = " + xmin + "\n");
        bw.write("       xmax = " + xmax + "\n");
        bw.write("       intervals: size = " + words.size() + "\n");
        for(int i = 0; i < words.size(); i++) {
            bw.write("       intervals [" + (i + 1) + "]:\n");
            bw.write("          xmin = " + Double.toString(words.get(i).start / 1000.0) + "\n");
            bw.write("          xmax = " + Double.toString(words.get(i).end / 1000.0) + "\n");
            bw.write("          text = " + escapeText(words.get(i).getText()) + "\n");
        }
        bw.write("    item [2]:\n");
        bw.write("       class = \"IntervalTier\"\n");
        bw.write("       name = \"phones\"\n");
        bw.write("       xmin = " + xmin + "\n");
        bw.write("       xmax = " + xmax + "\n");
        bw.write("       intervals: size = " + countWordPhones() + "\n");
        int phone = 1;
        for(CTMTimedWord w : words) {
            for(int i = 0; i < w.getPronunciation().size(); i++) {
                bw.write("       intervals [" + phone + "]:\n");
                bw.write("          xmin = " + Double.toString(w.getPronunciation().get(i).start / 1000.0) + "\n");
                bw.write("          xmax = " + Double.toString(w.getPronunciation().get(i).end / 1000.0) + "\n");
                bw.write("          text = " + escapeText(w.getPronunciation().get(i).getText()) + "\n");
                phone++;
            }
        }
        bw.flush();
        bw.close();
    }
}
