package io.github.jimregan.polishtranscriber;

public class PolishTokeniser {
    /** default whitespace regular expression pattern */
    public static final String RX_DEFAULT_PL_WHITESPACE = "[ \n\t\r]+";
    /** default letter regular expression pattern */
    public static final String RX_DEFAULT_PL_ALPHABET = "[A-ZĄĆĘŁŃÓŚŻŹa-ząćęłńóśżź]+";
    /** default uppercase regular expression pattern */
    public static final String RX_DEFAULT_PL_UPPERCASE = "[A-ZĄĆĘŁŃÓŚŻŹ]+";
    /** default lowercase regular expression pattern */
    public static final String RX_DEFAULT_PL_LOWERCASE = "[a-ząćęłńóśżź]+";
    /** default alpha-numeric regular expression pattern */
    public static final String RX_DEFAULT_PL_ALPHANUMERIC = "[0-9A-ZĄĆĘŁŃÓŚŻŹa-ząćęłńóśżź]+";

    /** default has-vowel regular expression */
    public static final String RX_DEFAULT_PL_HAS_VOWEL = ".*[aąeęioóuyAĄEĘIOÓUY].*";

}
