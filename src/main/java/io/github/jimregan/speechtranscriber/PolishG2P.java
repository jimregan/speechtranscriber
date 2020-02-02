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
package io.github.jimregan.speechtranscriber;

import java.util.*;

public class PolishG2P {
    private static final Map<String, String[]> map = new HashMap<String, String[]>();

    static {
        map.put("a", new String[]{"a"});
        map.put("aa", new String[]{"a", "ʔ", "a"});
        map.put("au", new String[]{"a", "w"});
        map.put("ą", new String[]{"ɔ̃"});
        map.put("b", new String[]{"b"});
        map.put("bi", new String[]{"bʲ", "i"});
        map.put("bia", new String[]{"bʲ", "a"});
        map.put("bią", new String[]{"bʲ", "ɔ̃"});
        map.put("bie", new String[]{"bʲ", "ɛ"});
        map.put("bię", new String[]{"bʲ", "ɛ̃"});
        map.put("bii", new String[]{"bʲ", "j", "i"});
        map.put("bio", new String[]{"bʲ", "ɔ"});
        map.put("bió", new String[]{"bʲ", "u"});
        map.put("biu", new String[]{"bʲ", "u"});
        map.put("c", new String[]{"t͡s"});
        map.put("ch", new String[]{"x"});
        map.put("chi", new String[]{"xʲ", "i"});
        map.put("chia", new String[]{"xʲ", "j", "a"});
        map.put("chią", new String[]{"xʲ", "j", "ɔ̃"});
        map.put("chie", new String[]{"xʲ", "j", "ɛ"});
        map.put("chię", new String[]{"xʲ", "j", "ɛ̃"});
        map.put("chii", new String[]{"xʲ", "j", "i"});
        map.put("chio", new String[]{"xʲ", "j", "ɔ"});
        map.put("chió", new String[]{"xʲ", "j", "u"});
        map.put("chiu", new String[]{"xʲ", "j", "u"});
        map.put("ci", new String[]{"t͡ɕ", "i"});
        map.put("cia", new String[]{"t͡ɕ", "a"});
        map.put("cią", new String[]{"t͡ɕ", "ɔ̃"});
        map.put("cie", new String[]{"t͡ɕ", "ɛ"});
        map.put("cię", new String[]{"t͡ɕ", "ɛ̃"});
        map.put("cio", new String[]{"t͡ɕ", "ɔ"});
        map.put("ció", new String[]{"t͡ɕ", "u"});
        map.put("ciu", new String[]{"t͡ɕ", "u"});
        map.put("ciy", new String[]{"t͡ɕ", "ɨ"});
        map.put("cz", new String[]{"t͡ʂ"});
        map.put("ć", new String[]{"t͡ɕ"});
        map.put("d", new String[]{"d"});
        map.put("dzi", new String[]{"d͡ʑ", "i"});
        map.put("dzia", new String[]{"d͡ʑ", "a"});
        map.put("dzią", new String[]{"d͡ʑ", "ɔ̃"});
        map.put("dzie", new String[]{"d͡ʑ", "ɛ"});
        map.put("dzię", new String[]{"d͡ʑ", "ɛ̃"});
        map.put("dzio", new String[]{"d͡ʑ", "ɔ"});
        map.put("dzió", new String[]{"d͡ʑ", "u"});
        map.put("dziu", new String[]{"d͡ʑ", "u"});
        map.put("dziy", new String[]{"d͡ʑ", "ɨ"});
        map.put("dż", new String[]{"d͡ʐ"});
        map.put("dź", new String[]{"d͡ʑ"});
        map.put("e", new String[]{"ɛ"});
        map.put("ee", new String[]{"ɛ", "ʔ", "ɛ"});
        map.put("eu", new String[]{"ɛ", "w"});
        map.put("ę", new String[]{"ɛ̃"});
        map.put("f", new String[]{"f"});
        map.put("fi", new String[]{"fʲ", "i"});
        map.put("fia", new String[]{"fʲ", "a"});
        map.put("fią", new String[]{"fʲ", "ɔ̃"});
        map.put("fie", new String[]{"fʲ", "ɛ"});
        map.put("fię", new String[]{"fʲ", "ɛ̃"});
        map.put("fii", new String[]{"fʲ", "j", "i"});
        map.put("fio", new String[]{"fʲ", "ɔ"});
        map.put("fió", new String[]{"fʲ", "u"});
        map.put("fiu", new String[]{"fʲ", "u"});
        map.put("g", new String[]{"ɡ"});
        map.put("gi", new String[]{"ɡʲ", "i"});
        map.put("gią", new String[]{"ɡʲ", "ɔ̃"});
        map.put("gia", new String[]{"ɡʲ", "j", "a"});
        map.put("gie", new String[]{"ɡʲ", "ɛ"});
        map.put("gię", new String[]{"ɡʲ", "ɛ̃"});
        map.put("gii", new String[]{"ɡʲ", "j", "i"});
        map.put("gio", new String[]{"ɡʲ", "j", "ɔ"});
        map.put("gió", new String[]{"ɡʲ", "j", "u"});
        map.put("giu", new String[]{"ɡʲ", "j", "u"});
        map.put("h", new String[]{"x"});
        map.put("hi", new String[]{"xʲ", "i"});
        map.put("hia", new String[]{"xʲ", "j", "a"});
        map.put("hią", new String[]{"xʲ", "j", "ɔ̃"});
        map.put("hie", new String[]{"xʲ", "j", "ɛ"});
        map.put("hię", new String[]{"xʲ", "j", "ɛ̃"});
        map.put("hii", new String[]{"xʲ", "j", "i"});
        map.put("hio", new String[]{"xʲ", "j", "ɔ"});
        map.put("hió", new String[]{"xʲ", "j", "u"});
        map.put("hiu", new String[]{"xʲ", "j", "u"});
        map.put("i", new String[]{"i"});
        map.put("j", new String[]{"j"});
        map.put("k", new String[]{"k"});
        map.put("ki", new String[]{"kʲ", "i"});
        map.put("kia", new String[]{"kʲ", "j", "a"});
        map.put("kią", new String[]{"kʲ", "j", "ɔ̃"});
        map.put("kie", new String[]{"kʲ", "ɛ"});
        map.put("kię", new String[]{"kʲ", "j", "ɛ̃"});
        map.put("kii", new String[]{"kʲ", "j", "i"});
        map.put("kio", new String[]{"kʲ", "j", "ɔ"});
        map.put("kió", new String[]{"kʲ", "j", "u"});
        map.put("kiu", new String[]{"kʲ", "j", "u"});
        map.put("l", new String[]{"l"});
        map.put("li", new String[]{"lʲ", "i"});
        map.put("lia", new String[]{"lʲ", "a"});
        map.put("lią", new String[]{"lʲ", "ɔ̃"});
        map.put("lie", new String[]{"lʲ", "ɛ"});
        map.put("lię", new String[]{"lʲ", "ɛ̃"});
        map.put("lii", new String[]{"lʲ", "j", "i"});
        map.put("lio", new String[]{"lʲ", "ɔ"});
        map.put("lió", new String[]{"lʲ", "u"});
        map.put("liu", new String[]{"lʲ", "u"});
        map.put("ł", new String[]{"w"});
        map.put("m", new String[]{"m"});
        map.put("mi", new String[]{"mʲ", "i"});
        map.put("mia", new String[]{"mʲ", "a"});
        map.put("mią", new String[]{"mʲ", "ɔ̃"});
        map.put("mie", new String[]{"mʲ", "ɛ"});
        map.put("mię", new String[]{"mʲ", "ɛ̃"});
        map.put("mii", new String[]{"mʲ", "j", "i"});
        map.put("mio", new String[]{"mʲ", "ɔ"});
        map.put("mió", new String[]{"mʲ", "u"});
        map.put("miu", new String[]{"mʲ", "u"});
        map.put("n", new String[]{"n"});
        map.put("ng", new String[]{"ŋ", "ɡ"});
        map.put("nk", new String[]{"ŋ", "k"});
        map.put("ni", new String[]{"ɲ", "i"});
        map.put("nia", new String[]{"ɲ", "a"});
        map.put("nią", new String[]{"ɲ", "ɔ̃"});
        map.put("nie", new String[]{"ɲ", "ɛ"});
        map.put("nię", new String[]{"ɲ", "ɛ̃"});
        map.put("nii", new String[]{"ɲ", "j", "i"});
        map.put("nio", new String[]{"ɲ", "ɔ"});
        map.put("nió", new String[]{"ɲ", "u"});
        map.put("niu", new String[]{"ɲ", "u"});
        map.put("ń", new String[]{"ɲ"});
        map.put("o", new String[]{"ɔ"});
        map.put("oo", new String[]{"ɔ", "ʔ", "ɔ"});
        map.put("ó", new String[]{"u"});
        map.put("p", new String[]{"p"});
        map.put("pi", new String[]{"pʲ", "i"});
        map.put("pia", new String[]{"pʲ", "a"});
        map.put("pią", new String[]{"pʲ", "ɔ̃"});
        map.put("pie", new String[]{"pʲ", "ɛ"});
        map.put("pię", new String[]{"pʲ", "ɛ̃"});
        map.put("pii", new String[]{"pʲ", "j", "i"});
        map.put("pio", new String[]{"pʲ", "ɔ"});
        map.put("pió", new String[]{"pʲ", "u"});
        map.put("piu", new String[]{"pʲ", "u"});
        map.put("qu", new String[]{"k", "v"});
        map.put("q", new String[]{"k", "u"});
        map.put("r", new String[]{"r"});
        map.put("ri", new String[]{"rʲ", "i"});
        map.put("ria", new String[]{"rʲ", "j", "a"});
        map.put("rią", new String[]{"rʲ", "j", "ɔ̃"});
        map.put("rie", new String[]{"rʲ", "j", "ɛ"});
        map.put("rię", new String[]{"rʲ", "j", "ɛ̃"});
        map.put("rii", new String[]{"rʲ", "j", "i"});
        map.put("rio", new String[]{"rʲ", "j", "ɔ"});
        map.put("rió", new String[]{"rʲ", "j", "u"});
        map.put("riu", new String[]{"rʲ", "j", "u"});
        map.put("rz", new String[]{"ʐ"});
        map.put("s", new String[]{"s"});
        map.put("si", new String[]{"ɕ", "i"});
        map.put("sia", new String[]{"ɕ", "a"});
        map.put("sią", new String[]{"ɕ", "ɔ̃"});
        map.put("sie", new String[]{"ɕ", "ɛ"});
        map.put("się", new String[]{"ɕ", "ɛ̃"});
        map.put("sio", new String[]{"ɕ", "ɔ"});
        map.put("sió", new String[]{"ɕ", "u"});
        map.put("siu", new String[]{"ɕ", "u"});
        map.put("siy", new String[]{"ɕ", "ɨ"});
        map.put("sz", new String[]{"ʂ"});
        map.put("ś", new String[]{"ɕ"});
        map.put("t", new String[]{"t"});
        map.put("u", new String[]{"u"});
        map.put("v", new String[]{"v"});
        map.put("vi", new String[]{"vʲ", "i"});
        map.put("via", new String[]{"vʲ", "a"});
        map.put("vią", new String[]{"vʲ", "ɔ̃"});
        map.put("vie", new String[]{"vʲ", "ɛ"});
        map.put("vię", new String[]{"vʲ", "ɛ̃"});
        map.put("vii", new String[]{"vʲ", "j", "i"});
        map.put("vio", new String[]{"vʲ", "ɔ"});
        map.put("vió", new String[]{"vʲ", "u"});
        map.put("viu", new String[]{"vʲ", "u"});
        map.put("w", new String[]{"v"});
        map.put("wi", new String[]{"vʲ", "i"});
        map.put("wia", new String[]{"vʲ", "a"});
        map.put("wią", new String[]{"vʲ", "ɔ̃"});
        map.put("wie", new String[]{"vʲ", "ɛ"});
        map.put("wię", new String[]{"vʲ", "ɛ̃"});
        map.put("wii", new String[]{"vʲ", "j", "i"});
        map.put("wio", new String[]{"vʲ", "ɔ"});
        map.put("wió", new String[]{"vʲ", "u"});
        map.put("wiu", new String[]{"vʲ", "u"});
        map.put("wj", new String[]{"vʲ", "j"});
        map.put("x", new String[]{"k", "s"});
        map.put("y", new String[]{"ɨ"});
        map.put("z", new String[]{"z"});
        map.put("ż", new String[]{"ʐ"});
        map.put("ź", new String[]{"ʑ"});
        map.put("zi", new String[]{"ʑ", "i"});
        map.put("zia", new String[]{"ʑ", "a"});
        map.put("zią", new String[]{"ʑ", "ɔ̃"});
        map.put("zie", new String[]{"ʑ", "ɛ"});
        map.put("zię", new String[]{"ʑ", "ɛ̃"});
        map.put("zio", new String[]{"ʑ", "ɔ"});
        map.put("zió", new String[]{"ʑ", "u"});
        map.put("ziu", new String[]{"ʑ", "u"});
        map.put("-", new String[]{""});
        map.put("'", new String[]{""});
    }

    private static class Piece {
        String g;
        String[] p;
        Piece(String g, String[] p) {
            this.g = g;
            this.p = p;
        }
    }

    public static Piece[] simpleG2P(String in) {
        List<Piece> tmp = new ArrayList<Piece>();
        for (int i = 0; i < in.length(); i++) {
            int ext = 1;
            while ((i + ext + 1) < in.length() && map.containsKey(in.substring(i, i + ext + 1))) {
                ext++;
            }
            String g = in.substring(i, i + ext);
            tmp.add(new Piece(g, map.get(g)));
            if (ext > 1) {
                i += ext - 1;
                ext = 1;
            }
        }
        return tmp.toArray(new Piece[tmp.size()]);
    }

    /**
     * Converts 'nasal' final 'ę' to 'e'
     * Makes a copy, because in many situations, we want both
     * @param in
     * @return
     */
    private static String[] denasaliseFinalE(String[] in) {
        String[] tmp = Arrays.copyOf(in, in.length);
        if (in[in.length - 1].equals("ɛ̃")) {
            tmp[tmp.length - 1] = "ɛ";
        }
        return tmp;
    }

    private static String[] piecesToString(Piece[] pieces) {
        List<String> tmp = new ArrayList<String>();
        for (Piece p : pieces) {
            tmp.addAll(Arrays.asList(p.p));
        }
        return tmp.toArray(new String[tmp.size()]);
    }

    private static boolean isVowelPhone(String s) {
        switch (s) {
            case "a":
            case "ɛ":
            case "ɛ̃":
            case "i":
            case "ɨ":
            case "ɔ":
            case "ɔ̃":
            case "u":
                return true;
            default:
                return false;
        }
    }

    /**
     * Return true if phoneme is a vowel, liquid, or nasal
     * @param s
     * @return
     */
    private static boolean isVLNPhone(String s) {
        switch (s) {
            case "a":
            case "ɛ":
            case "ɛ̃":
            case "i":
            case "ɨ":
            case "ɔ":
            case "ɔ̃":
            case "u":
            case "m":
            case "mʲ":
            case "n":
            case "ɲ":
            case "ŋ":
            case "l":
            case "lʲ":
            case "j":
            case "r":
            case "rʲ":
                return true;
            default:
                return false;
        }
    }

    private static char sylMarks(char c) {
        switch (c) {
            case '.':
                return '.';
            case '\'':
                return 'ˈ';
            case ',':
                return 'ˌ';
            default:
                return c;
        }
    }

    private static boolean isForwardVoiced(Piece p) {
        if(p.p.length == 1 && p.p[0].equals("v") || p.p[0].equals("vʲ")) {
            return true;
        }
        // 'rz' is forward voiced, 'ż' is not
        if(p.g.equals("rz") && p.p[0].equals("ʐ")) {
            return true;
        }
        return false;
    }

    private static String devoice(String s) {
        switch(s) {
            case "b":
                return "p";
            case "d":
                return "t";
            case "d͡z":
                return "t͡s";
            case "d͡ʑ":
                return "t͡ɕ";
            case "d͡ʐ":
                return "t͡ʂ";
            case "ɡ":
                return "k";
            case "v":
                return "f";
            case "vʲ":
                return "fʲ";
            case "z":
                return "s";
            case "ʑ":
                return "ɕ";
            case "ʐ":
                return "ʂ";

            default:
                return null;
        }
    }
    private static String revoice(String s) {
        switch(s) {
            case "p":
                return "b";
            case "t":
                return "d";
            case "t͡s":
                return "d͡z";
            case "t͡ɕ":
                return "d͡ʑ";
            case "t͡ʂ":
                return "d͡ʐ";
            case "k":
                return "ɡ";
            case "f":
                return "v";
            case "fʲ":
                return "vʲ";
            case "s":
                return "z";
            case "ɕ":
                return "ʑ";
            case "ʂ":
                return "ʐ";

            default:
                return null;
        }
    }

    private static String denasalise(String in) {
        if(in.equals("ɛ̃")) {
            return "ɛ";
        } else if(in.equals("ɔ̃")) {
            return "ɔ";
        } else {
            return in;
        }
    }

    public static void main(String[] args) {

    }
}
