package io.github.jimregan.speechtranscriber;

public class Utils {
    static String join(String joiner, String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i]);
            sb.append(joiner);
        }
        sb.append(arr[arr.length - 1]);
        return sb.toString();
    }
    static String join(String[] arr) {
        return join("", arr);
    }
}
