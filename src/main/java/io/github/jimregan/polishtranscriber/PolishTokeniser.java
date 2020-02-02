/*
 * Copyright 2019 Jim O'Regan <jaoregan@tcd.ie>
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
package io.github.jimregan.polishtranscriber;

public class PolishTokeniser {
    /** default whitespace regular expression pattern */
    public static final String RX_DEFAULT_PL_WHITESPACE = "[ \n\t\r]+";
    /** default letter regular expression pattern */
    public static final String RX_DEFAULT_PL_ALPHABET = "[A-ZĄĆĘŁŃÓŚŻŹa-ząćęłńóśżź]+";
    /** default uppercase regular expression pattern */
    public static final String RX_DEFAULT_PL_UPPERCASE = "[A-ZĄĆĘŁŃÓŚŻŹ]+";
    /** default lowercase regular expression pattern */
    public static final String RX_DEFAULT_PL_LOWERCASE = "[a-ząćęłńóśżź]+";
    /** default alpha-numeric regular expression pattern */
    public static final String RX_DEFAULT_PL_ALPHANUMERIC = "[0-9A-ZĄĆĘŁŃÓŚŻŹa-ząćęłńóśżź]+";

    /** default has-vowel regular expression */
    public static final String RX_DEFAULT_PL_HAS_VOWEL = ".*[aąeęioóuyAĄEĘIOÓUY].*";

}
