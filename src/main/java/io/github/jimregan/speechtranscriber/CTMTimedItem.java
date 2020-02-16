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

public class CTMTimedItem {
    long start;
    long end;
    String text;
    CTMTimedItem(String text, long start, long end) {
        this.text = text;
        this.start = start;
        this.end = end;
    }
    CTMTimedItem(String text, String start, String duration) {
        this.text = text;
        if(!checkTime(start) || !checkTime(duration)) {
            throw new RuntimeException("Invalid time: (" + text + ") [" + start + ":" + end + "]");
        }
        this.start = getTime(start);
        this.end = this.start + getTime(duration);
    }
    private static boolean checkTime(String s) {
        return s.matches("[0-9]+\\.[0-9][0-9][0-9]");
    }
    private static long getTime(String s) {
        return Long.parseLong(s.replace(".", ""));
    }
}
