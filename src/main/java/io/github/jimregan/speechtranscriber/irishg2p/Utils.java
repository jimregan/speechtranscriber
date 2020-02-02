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
package io.github.jimregan.speechtranscriber.irishg2p;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static boolean startsSlenderVowel(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return false;
        }
        if (s.length() >= 2 && s.startsWith("ae")) {
            return false;
        }
        switch (s.charAt(0)) {
            case 'e':
            case 'i':
            case 'é':
            case 'í':
                return true;
            default:
                return false;
        }
    }
    public static boolean endsSlenderVowel(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return false;
        }
        if (s.length() >= 2 && s.endsWith("ae")) {
            return false;
        }
        switch (s.charAt(s.length() - 1)) {
            case 'e':
            case 'i':
            case 'é':
            case 'í':
                return true;
            default:
                return false;
        }
    }
    public static boolean arrayEquals(String[] a, String[] b, int from) {
        if (a.length > b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if(!a[i].equals(b[from + i])) {
                return false;
            }
        }
        return true;
    }
    public static boolean arrayEquals(String[] a, String[] b) {
        return arrayEquals(a, b, 0);
    }

    public static boolean checkContext(G2PPiece piece, String curstring, int i) throws Exception {
        if(piece.hasContext()) {
            Pattern p = Pattern.compile(piece.makeMatchString());
            Matcher m = p.matcher(curstring);
            if(piece.getContext().startsWith("^") && i != 0) {
                return false;
            }
            if(!m.matches()) {
                return false;
            }
            if(piece.getContext().startsWith("^") || piece.getContext().endsWith("$")) {
                return true;
            }
            m.reset();
            while(m.find()) {
                if(m.start(1) == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
