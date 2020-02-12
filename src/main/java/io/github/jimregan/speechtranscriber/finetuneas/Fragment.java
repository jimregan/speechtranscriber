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
package io.github.jimregan.speechtranscriber.finetuneas;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fragment {
    String id;
    String language;
    @JsonIgnore
    int start;
    @JsonIgnore
    int start_ms;
    @JsonIgnore
    int end;
    @JsonIgnore
    int end_ms;
    List<String> lines;
    public Fragment() {
        this.lines = new ArrayList<>();
    }
    public Fragment(String id, String start, String end) {
        this();
        this.id = id;
        setStart(start);
        setEnd(end);
    }
    public void addLine(String s) {
        this.lines.add(s);
    }
    public void addLines(String[] s) {
        this.lines.addAll(Arrays.asList(s));
    }
    public void addLines(List<String> l) {
        this.lines.addAll(l);
    }
    @JsonSetter("start")
    public void setStart(String start) {
        String[] t = start.split("\\.");
        this.start = Integer.parseInt(t[0]);
        this.start_ms = Integer.parseInt(t[1]);
    }
    @JsonGetter("start")
    public String getStart() {
        return String.format("%d.%03d", this.start, this.start_ms);
    }
    @JsonSetter("end")
    public void setEnd(String end) {
        String[] t = end.split("\\.");
        this.end = Integer.parseInt(t[0]);
        this.end_ms = Integer.parseInt(t[1]);
    }
    @JsonGetter("end")
    public String getEnd() {
        return String.format("%d.%03d", this.end, this.end_ms);
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public List<String> getLines() {
        return lines;
    }
    public void setLines(List<String> lines) {
        this.lines = lines;
    }
}
