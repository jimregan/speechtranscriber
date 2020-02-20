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
package io.github.jimregan.speechtranscriber.abair.corpus;

import java.io.File;
import java.io.IOException;

public class CorpusFileEntry {
    String id;
    String dialect;
    String path;
    String text;
    String[] phones;

    public CorpusFileEntry() {}
    public CorpusFileEntry(String id, String dialect, String path, String text, String[] phones) {
        this.id = id;
        this.dialect = dialect;
        this.path = path;
        this.text = text;
        this.phones = phones;
    }
    public static CorpusFileEntry fromLine(String s) throws Exception {
        String[] parts = s.split("\t");
        if(parts.length != 5) {
            throw new IOException("Incorrect number of fields: " + s);
        }
        String[] phones = parts[4].split(" # ");
        return new CorpusFileEntry(parts[0], parts[1], parts[2], parts[3], phones);
    }

    String[] getWords() {
        return text.split(" ");
    }
    boolean checkWords() {
        return getWords().length == phones.length;
    }
    boolean fileExists() {
        File f = new File(this.path);
        return f.exists();
    }
}
