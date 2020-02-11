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
package io.github.jimregan.speechtranscriber.subtitles;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadVTT {
    public static List<SimpleTimedObject> readSimpleVTT(BufferedReader br) throws IOException {
        List<SimpleTimedObject> out = new ArrayList<>();
        int lineno = 0;
        String line;
        Pattern p = Pattern.compile(SimpleTime.TIME_PATTERN);
        SimpleTimedObject current = new SimpleTimedObject();
        String tmpID = null;
        int line_type = 0;
        while((line = br.readLine()) != null) {
            lineno++;
            if(lineno == 1) {
                if(line.startsWith("\uFEFF")) {
                    line = line.substring(1);
                }
                if(!line.startsWith("WEBVTT")) {
                    throw new IOException("Missing WEBVTT header");
                }
            } else {
                if(line_type == 0 || line_type == 1) {
                    if(line.contains("-->")) {
                        line_type = 2;
                        String[] parts = line.split("-->");
                        Matcher m = p.matcher(parts[0].trim());
                        if(!m.matches()) {
                            throw new IOException("Error reading date in line " + lineno + ": " + line);
                        }
                        String end;
                        if(parts[1].trim().contains(" ")) {
                            String[] tmp = parts[1].trim().split(" ");
                            end = tmp[0];
                        } else {
                            end = parts[1].trim();
                        }
                        Matcher m2 = p.matcher(end);
                        if(!m2.matches()) {
                            throw new IOException("Error reading date in line " + lineno + ": " + line);
                        }
                        current = new SimpleTimedObject(parts[0].trim(), end);
                        if(tmpID != null) {
                            current.setId(tmpID);
                            tmpID = null;
                        }
                    } else {
                        line_type = 1;
                        tmpID = line.trim();
                    }
                } else if (line_type == 2 || line_type == 3) {
                    if(line.trim().equals("")) {
                        line_type = 0;
                        out.add(current);
                        current = new SimpleTimedObject();
                    } else {
                        line_type = 3;
                        if(line.trim() != null) {
                            current.addText(line.trim());
                        }
                    }
                } else if(line.trim().equals("")) {
                    line_type = 0;
                    out.add(current);
                    current = new SimpleTimedObject();
                }
            }
        }
        out.add(current);
        return out;
    }
    public static List<SimpleTimedObject> readSimpleVTT(InputStreamReader isr) throws IOException {
        return readSimpleVTT(new BufferedReader(isr));
    }
    public static List<SimpleTimedObject> readSimpleVTT(InputStream is) throws IOException {
        return readSimpleVTT(new InputStreamReader(is));
    }
    public static List<SimpleTimedObject> readSimpleVTT(FileInputStream fis) throws IOException {
        return readSimpleVTT(new InputStreamReader(fis, StandardCharsets.UTF_8));
    }
    public static List<SimpleTimedObject> readSimpleVTT(File f) throws IOException {
        return readSimpleVTT(new FileInputStream(f));
    }
    public static List<SimpleTimedObject> readSimpleVTT(String filename) throws IOException {
        return readSimpleVTT(new File(filename));
    }
}
