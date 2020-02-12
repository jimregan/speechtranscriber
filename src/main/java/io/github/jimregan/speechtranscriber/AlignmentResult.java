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

import edu.cmu.sphinx.alignment.LongTextAligner;
import edu.cmu.sphinx.result.WordResult;

import java.util.ArrayList;
import java.util.List;

public class AlignmentResult {
    public static List<String> extractCTMish(List<WordResult> results, LongTextAligner textAligner, List<String> words) {
        int[] aid = textAligner.align(words);
        List<String> out = new ArrayList<>();

        int lastId = -1;
        for (int i = 0; i < aid.length; ++i) {
            if (aid[i] == -1) {
                System.out.format("- %s\n", words.get(i));
            } else {
                if (aid[i] - lastId > 1) {
                    for (WordResult result : results.subList(lastId + 1, aid[i])) {
                        out.add(String.format("+ %s\t%s\t%s\n",
                                result.getWord().getSpelling(),
                                result.getTimeFrame(),
                                result.getPronunciation().toString().trim()));
                    }
                }
                out.add(String.format("  %s\t%s\t%s\n",
                        results.get(aid[i]).getWord().getSpelling(),
                        results.get(aid[i]).getTimeFrame(),
                        results.get(aid[i]).getPronunciation().toString().trim()));
                lastId = aid[i];
            }
        }

        if (lastId >= 0 && results.size() - lastId > 1) {
            for (WordResult result : results.subList(lastId + 1, results.size())) {
                out.add(String.format("+ %-25s [%s]\n", result.getWord()
                        .getSpelling(), result.getTimeFrame()));
            }
        }
        return out;
    }
}
