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

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.cmu.sphinx.api.SpeechAligner;
import edu.cmu.sphinx.result.WordResult;
import edu.cmu.sphinx.alignment.LongTextAligner;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;

import static java.lang.System.exit;

public class Transcriber {
    private static final String PL_ACOUSTIC_MODEL_PATH =
            "resource:/io/github/jimregan/cmusphinx-clarinpl/";
    private static final String PL_DICTIONARY_PATH =
            "resource:/io/github/jimregan/cmusphinx-clarinpl/pl.dic";
    private static final String PL_LANGUAGE_MODEL_PATH =
            "resource:/io/github/jimregan/cmusphinx-clarinpl/pl.lm.DMP";
    private static final String PL_G2P_MODEL_PATH =
            "resource:/io/github/jimregan/cmusphinx-clarinpl/model-6.fst";

    public static void main(String args[]) throws Exception {
        ArgumentParser parser = ArgumentParsers
                .newFor("Transcriber")
                .build()
                .defaultHelp(true)
                .description("Transcribe audio");
        parser.addArgument("-l", "--lang")
                .choices("pl", "ga").setDefault("pl")
                .help("Specify language");
        parser.addArgument("-F", "--ffmpeg")
                .help("Path to ffmpeg");
        parser.addArgument("-P", "--ffprobe")
                .help("Path to ffprobe");
        parser.addArgument("-a", "--audio")
                .required(true)
                .help("Path to audio file");
        parser.addArgument("-t", "--text")
                .required(true)
                .help("Path to text file");
        parser.addArgument("-L", "--lm")
                .help("Path to language model");
        parser.addArgument("-G", "--g2p")
                .help("Path to g2p model");
        parser.addArgument("-D", "--dict")
                .help("Path to pronunciation dictionary");
        parser.addArgument("-A", "--am")
                .help("Path to acoustic model");
        Namespace ns = null;
        try {
            ns = parser.parseArgs(args);
        } catch (ArgumentParserException e) {
            parser.handleError(e);
            exit(1);
        }
        String language = ns.getString("lang");
        String audioFilePath = ns.getString("audio");
        String textFilePath = ns.getString("text");
        String ffmpegPath = ns.getString("ffmpeg");
        String ffprobePath = ns.getString("ffprobe");

        String lm = ns.getString("lm");
        String am = ns.getString("am");
        String g2p = ns.getString("g2p");
        String dict = ns.getString("dict");
        if(language == null) {
            if(am == null) {
                System.err.println("Error: no acoustic model or language specified");
                exit(1);
            }
            if(dict == null) {
                System.err.println("Error: no dictionary or language specified");
                exit(1);
            }
        } else if(language.equals("pl")) {
            if(am == null) {
                am = PL_ACOUSTIC_MODEL_PATH;
            }
            if(lm == null) {
                lm = PL_LANGUAGE_MODEL_PATH;
            }
            if(dict == null) {
                dict = PL_DICTIONARY_PATH;
            }
            if(g2p == null) {
                g2p = PL_G2P_MODEL_PATH;
            }
        }

        AudioFileFormat af = AudioSystem.getAudioFileFormat(new File(audioFilePath));

        URL audioUrl = new File(audioFilePath).toURI().toURL();
        String[] lines = Utils.readTextLines(textFilePath);
        String transcript = String.join("\n", lines);

        SpeechAligner aligner = new SpeechAligner(am, dict, g2p);

        List<WordResult> results = aligner.align(audioUrl, transcript);
        List<String> stringResults = new ArrayList<String>();
        for (WordResult wr : results) {
            stringResults.add(wr.getWord().getSpelling());
        }

        LongTextAligner textAligner =
                new LongTextAligner(stringResults, 2);
        List<String> sentences = aligner.getTokenizer().expand(transcript);
        List<String> words = aligner.sentenceToWords(sentences);

        int[] aid = textAligner.align(words);

        int lastId = -1;
        for (int i = 0; i < aid.length; ++i) {
            if (aid[i] == -1) {
                System.out.format("- %s\n", words.get(i));
            } else {
                if (aid[i] - lastId > 1) {
                    for (WordResult result : results.subList(lastId + 1,
                            aid[i])) {
                        System.out.format("+ %s\t%s\t%s\n", result.getWord()
                                .getSpelling(), result.getTimeFrame(),
                                result.getPronunciation().toString().trim());
                    }
                }
                System.out.format("  %s\t%s\t%s\n", results.get(aid[i])
                        .getWord().getSpelling(), results.get(aid[i])
                        .getTimeFrame(), results.get(aid[i])
                        .getPronunciation().toString().trim());
                lastId = aid[i];
            }
        }

        if (lastId >= 0 && results.size() - lastId > 1) {
            for (WordResult result : results.subList(lastId + 1,
                    results.size())) {
                System.out.format("+ %-25s [%s]\n", result.getWord()
                        .getSpelling(), result.getTimeFrame());
            }
        }
    }}
