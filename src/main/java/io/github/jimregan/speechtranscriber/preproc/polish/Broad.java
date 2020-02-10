package io.github.jimregan.speechtranscriber.preproc.polish;

import java.util.ArrayList;
import java.util.List;

public class Broad {
    public static String[] proc(String[] in) {
        List<String> out = new ArrayList<>();
        for (String line : in) {
            if (line.equals("E. T. A. Hoffmann")) {
                out.add("Ernst Teodor Amadeusz Hoffmann");
            } else if (line.startsWith("ISBN")) {
                continue;
            } else if (line.equals("-----")) {
                break;
            } else {
                out.add(line);
            }

        }
        return out.toArray(new String[out.size()]);
    }
}
