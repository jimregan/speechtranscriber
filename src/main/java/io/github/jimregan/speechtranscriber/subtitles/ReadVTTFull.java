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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class ReadVTTFull {
    private static byte[] buf;
    static byte[] fillBuf(String filepath) throws IOException {
        File f = new File(filepath);
        return Files.readAllBytes(f.toPath());
    }
    public static byte[] cleanBuffer(byte[] in) {
        byte[] out = new byte[in.length * 3];
        for (int i = 0, j = 0; i < in.length && j < out.length; i++, j++) {
            if(in[i] == 0) {
                out[j] = (byte) 0xEF;
                out[j + 1] = (byte) 0xBF;
                out[j + 2] = (byte) 0xBD;
                j += 2;
            } else if(in[i] == 0x0D && i < in.length - 1 && in[i + 1] == 0x0A) {
                out[j] = 0x0A;
                i++;
            } else if(in[i] == 0x0D) {
                out[j] = 0x0A;
            } else {
                out[j] = in[i];
            }
        }
        return out;
    }
    void parse(String filename) throws FileNotFoundException, IOException {
        byte[] buffer = fillBuf(filename);
        if(buffer.length < 6) {
            throw new IOException("Invalid VTT file: does not begin with \"WEBVTT\"");
        }
        int cur = 0;
        //if(buffer[0] == '')
    }
}
