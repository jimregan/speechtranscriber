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

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TextSentenceTest {
    @Test
    public void testTextSentence() {
        List<String> sent = Arrays.asList("a test sentence".split(" "));
        TextSentence sent1 = new TextSentence(sent);
        assertEquals(3, sent1.getWords().size());
        assertEquals(true, sent1.getWords().get(0).isStart);
        assertEquals(false, sent1.getWords().get(0).isEnd);
        assertEquals(false, sent1.getWords().get(1).isStart);
        assertEquals(false, sent1.getWords().get(1).isEnd);
        assertEquals(true, sent1.getWords().get(2).isEnd);
        assertEquals(false, sent1.getWords().get(2).isStart);
        TextSentence sent2 = new TextSentence(new String[]{"foo"});
        assertEquals(1, sent2.getWords().size());
        assertEquals(true, sent2.getWords().get(0).isStart);
        assertEquals(true, sent2.getWords().get(0).isEnd);
    }
}