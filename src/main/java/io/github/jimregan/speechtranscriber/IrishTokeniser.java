package io.github.jimregan.speechtranscriber;

public class IrishTokeniser {
    /** default whitespace regular expression pattern */
    public static final String RX_DEFAULT_GA_WHITESPACE = "[ \n\t\r]+";
    /** default letter regular expression pattern */
    public static final String RX_DEFAULT_GA_ALPHABET = "[A-ZÁÉÍÓÚa-záéíóú]+";
    /** default uppercase regular expression pattern */
    public static final String RX_DEFAULT_GA_UPPERCASE = "[A-ZÁÉÍÓÚ]+";
    /** default lowercase regular expression pattern */
    public static final String RX_DEFAULT_GA_LOWERCASE = "[a-záéíóú]+";
    /** default alpha-numeric regular expression pattern */
    public static final String RX_DEFAULT_GA_ALPHANUMERIC = "[0-9A-ZÁÉÍÓÚáéíóú]+";

    /** default has-vowel regular expression */
    public static final String RX_DEFAULT_GA_HAS_VOWEL = ".*[aáeéiíoóuúAÁEÉIÍOÓUÚ].*";

}
