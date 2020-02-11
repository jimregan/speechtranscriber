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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleTime {
    int hours;
    int minutes;
    int seconds;
    int millis;
    SimpleTime(int h, int m, int s, int ms) {
        this.hours = h;
        this.minutes = m;
        this.seconds = s;
        this.millis = ms;
    }
    public int getMilliseconds() {
        return (this.millis + (this.getSeconds() * 100));
    }
    public static SimpleTime fromString(String s) {
        Pattern p = Pattern.compile("([0-9][0-9]):([0-9][0-9]):([0-9][0-9])[,\\.]([0-9][0-9][0-9])");
        Matcher matcher = p.matcher(s);
        if(matcher.matches()) {
            int h = Integer.parseInt(matcher.group(1));
            int m = Integer.parseInt(matcher.group(2));
            int sec = Integer.parseInt(matcher.group(3));
            int ms = Integer.parseInt(matcher.group(4));
            return new SimpleTime(h, m, sec, ms);
        } else {
            return null;
        }
    }
    public int getSeconds() {
        return (this.seconds
                + (this.minutes * 60)
                + (this.hours * 60 * 60));
    }
    public String toVTTString() {
        return String.format("%02d:%02d:%02d.%03d", this.hours, this.minutes, this.seconds, this.millis);
    }
    public String toSRTString() {
        return String.format("%02d:%02d:%02d,%03d", this.hours, this.minutes, this.seconds, this.millis);
    }
    public String toFTASString() {
        return String.format("%d.%03d", getSeconds(), this.millis);
    }
}
