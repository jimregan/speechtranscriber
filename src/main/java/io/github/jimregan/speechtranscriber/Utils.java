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

public class Utils {
    static String join(String joiner, String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i]);
            sb.append(joiner);
        }
        sb.append(arr[arr.length - 1]);
        return sb.toString();
    }
    static String join(String[] arr) {
        return join("", arr);
    }

    public static String trim(String s) {
        int begin = 0;
        int end = s.length();

        for(int i = 0; i < s.length(); i++) {
            if(Character.isWhitespace(s.charAt(i))) {
                begin++;
            } else {
                break;
            }
        }
        for(int j = s.length() - 1; j >= 0; j--) {
            if(Character.isWhitespace(s.charAt(j))) {
                end--;
            } else {
                break;
            }
        }
        return s.substring(begin, end);
    }
}
