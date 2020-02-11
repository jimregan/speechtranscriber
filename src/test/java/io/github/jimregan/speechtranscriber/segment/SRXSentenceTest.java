package io.github.jimregan.speechtranscriber.segment;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

import java.io.IOException;

public class SRXSentenceTest {

    @Test
    public void testGetSegments() throws IOException {
        SRXSentence sents = new SRXSentence("pl");
        String sample = "To mały test. Blah np. blah, blah. Foo blah.";
        String[] exp = new String[]{"To mały test. ", "Blah np. blah, blah. ", "Foo blah."};
        String[] out = sents.getSegments(new String[]{sample}, false);
        assertArrayEquals(exp, out);
    }
}