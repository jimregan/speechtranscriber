package io.github.jimregan.speechtranscriber;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.cmu.sphinx.api.SpeechAligner;
import edu.cmu.sphinx.result.WordResult;
import edu.cmu.sphinx.alignment.LongTextAligner;

public class Transcriber {
    private static final String ACOUSTIC_MODEL_PATH =
            "resource:/io/github/jimregan/cmusphinx-clarinpl/";
    private static final String DICTIONARY_PATH =
            "resource:/io/github/jimregan/cmusphinx-clarinpl/pl.dic";
    private static final String LANGUAGE_MODEL_PATH =
            "resource:/io/github/jimregan/cmusphinx-clarinpl/pl.lm.DMP";
    private static final String G2P_MODEL_PATH =
            "resource:/io/github/jimregan/cmusphinx-clarinpl/model-6.fst";

    public static void main(String args[]) throws Exception {
        URL audioUrl = null;
        String transcript = null;
        if (args.length > 1) {
            audioUrl = new File(args[0]).toURI().toURL();
            Scanner scanner = new Scanner(new File(args[1]));
            scanner.useDelimiter("\\Z");
            transcript = scanner.next();
            scanner.close();
        }

        SpeechAligner aligner =
                new SpeechAligner(ACOUSTIC_MODEL_PATH, DICTIONARY_PATH, G2P_MODEL_PATH);

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
                                result.getPronunciation().toString());
                    }
                }
                System.out.format("  %s\t%s\t%s\n", results.get(aid[i])
                        .getWord().getSpelling(), results.get(aid[i])
                        .getTimeFrame(), results.get(aid[i])
                        .getPronunciation().toString());
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
