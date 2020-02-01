package io.github.jimregan.polishtranscriber.irishg2p;

public class Utils {
    public static boolean startsSlenderVowel(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return false;
        }
        if (s.length() >= 2 && s.startsWith("ae")) {
            return false;
        }
        switch (s.charAt(0)) {
            case 'e':
            case 'i':
            case 'é':
            case 'í':
                return true;
            default:
                return false;
        }
    }
    public static boolean endsSlenderVowel(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return false;
        }
        if (s.length() >= 2 && s.endsWith("ae")) {
            return false;
        }
        switch (s.charAt(s.length() - 1)) {
            case 'e':
            case 'i':
            case 'é':
            case 'í':
                return true;
            default:
                return false;
        }
    }
}
