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

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;

public class SegmentTest {

    private static final List<G2PPiece> l(G2PPiece g) {
        List<G2PPiece> out = new ArrayList<>();
        out.add(g);
        return out;
    }
    private static final Entry athas = Entry.fromLine("áthas aː h ə sˠ");
    private static Map<String, List<G2PPiece>> getAthasMap() {
        Map<String, List<G2PPiece>> out = new HashMap<>();
        out.put("a", l(new ShortVowel("a", "a")));
        out.put("á", l(new LongVowel("á", "aː")));
        out.put("th", l(new Consonant("th", "h", "h")));
        out.put("s", l(new Consonant("s", "sˠ", "ʃ")));
        return out;
    }

    @Test
    public void testSegment() throws Exception {
        List<G2PPiece> t1 = Segment.segment(athas, getAthasMap());
        assertEquals(t1.size(), 4);
        assertEquals(t1.get(0).getGrapheme(), "á");
        assertEquals(t1.get(1).getGrapheme(), "th");
        assertEquals(t1.get(2).getGrapheme(), "a");
        assertEquals(t1.get(3).getGrapheme(), "s");
    }
}