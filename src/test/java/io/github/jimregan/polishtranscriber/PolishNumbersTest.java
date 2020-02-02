package io.github.jimregan.polishtranscriber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PolishNumbersTest {

    @Test
    public void testInflectOrdinal() {
        assertEquals("drugi", PolishNumbers.inflectOrdinal("drugi"));
        assertEquals("druga", PolishNumbers.inflectOrdinal("drugi", "f"));
        assertEquals("drugim", PolishNumbers.inflectOrdinal("drugi", "m", "loc"));
    }
}