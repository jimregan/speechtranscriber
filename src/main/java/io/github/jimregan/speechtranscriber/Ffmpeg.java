/*
 * Copyright 2019-2020 Jim O'Regan <jaoregan@tcd.ie>
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

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.builder.FFmpegBuilder;

import java.io.File;
import java.util.Locale;

public class Ffmpeg {
    private static final String DEFAULT_FFMPEG_PATH_WINDOWS = "C:\\Program Files (x86)\\FFmpeg\\bin\\ffmpeg.exe";
    private static final String DEFAULT_FFPROBE_PATH_WINDOWS = "C:\\Program Files (x86)\\FFmpeg\\bin\\ffprobe.exe";
    private static final String DEFAULT_FFMPEG_PATH_LINUX = "/usr/bin/ffmpeg";
    private static final String DEFAULT_FFPROBE_PATH_LINUX = "/usr/bin/ffprobe";
    private static String defaultFFmpegPath() {
        String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        if(OS.contains("windows")) {
            return DEFAULT_FFMPEG_PATH_WINDOWS;
        } else if(OS.contains("linux")) {
            return DEFAULT_FFMPEG_PATH_LINUX;
        } else {
            return null;
        }
    }
    private static String defaultFFprobePath() {
        String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        if(OS.contains("windows")) {
            return DEFAULT_FFPROBE_PATH_WINDOWS;
        } else if(OS.contains("linux")) {
            return DEFAULT_FFPROBE_PATH_LINUX;
        } else {
            return null;
        }
    }
    //FFmpeg ffmpeg = new FFmpeg();
    FFmpegBuilder buildBuilder(String in, String out) {
        FFmpegBuilder fb = new FFmpegBuilder();
        return fb.setInput(in)
                 .addOutput(out)
                 .setAudioChannels(1)
                 .setAudioCodec("pcm_s16le")
                 .setAudioSampleRate(16_000)
                 .done();
    }
}
