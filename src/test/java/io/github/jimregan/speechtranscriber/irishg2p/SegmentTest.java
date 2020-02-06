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
    }
}