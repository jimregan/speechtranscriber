package io.github.jimregan.polishtranscriber.irishg2p;

public class RLongVowel extends LongVowel {
    public RLongVowel(String g, String p, String unstressed) {
        super(g, p);
        this.unstressed = unstressed;
    }
    public RLongVowel(String g, String p, String unstressed, String context) {
        this(g, p, unstressed);
        this.setContext(context);
    }
}
