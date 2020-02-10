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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PolishNumbers {
    static final Map<Integer, String> HUNDREDS;
    static final Map<String, String> ROMAN_ORDINALS;
    static final Map<String, String[]> PLURALS;
    static final Map<Integer, String> TEENS_ORD;
    static final Map<Integer, String> TEENS;
    static final Map<Integer, String> TENS;
    static final Map<Integer, String> ONES;
    static final Map<Integer, String> ONES_ORD;
    static final Map<String, String> CARD_TO_ORD;
    static {
        Map<Integer, String> hundreds = new HashMap<>();
        hundreds.put(1, "sto");
        hundreds.put(2, "dwieście");
        hundreds.put(3, "trzysta");
        hundreds.put(4, "czterysta");
        hundreds.put(5, "pięćset");
        hundreds.put(6, "sześćset");
        hundreds.put(7, "siedemset");
        hundreds.put(8, "osiemset");
        hundreds.put(9, "dziewięćset");
        HUNDREDS = Collections.unmodifiableMap(hundreds);

        Map<String, String> romans = new HashMap<>();
        romans.put("I", "pierwszy");
        romans.put("II", "drugi");
        romans.put("III", "trzeci");
        romans.put("IV", "czwarty");
        romans.put("V", "piąty");
        romans.put("VI", "szósty");
        romans.put("VII", "siódmy");
        romans.put("VIII", "ósmy");
        romans.put("IX", "dziewiąty");
        romans.put("X", "dziesiąty");
        romans.put("XI", "jedenasty");
        romans.put("XII", "dwunasty");
        romans.put("XIII", "trzynasty");
        romans.put("XIV", "czternasty");
        romans.put("XV", "piętnasty");
        romans.put("XVI", "szesnasty");
        romans.put("XVII", "siedemnasty");
        romans.put("XVIII", "osiemnasty");
        romans.put("XIX", "dziewiętnasty");
        romans.put("XX", "dwudziesty");
        romans.put("XXX", "trzydziesty");
        romans.put("XL", "czterdziesty");
        romans.put("L", "pięćdziesiąty");
        romans.put("LX", "sześćdziesiąty");
        romans.put("LXX", "siedemdziesiąty");
        romans.put("LXXX", "osiemdziesiąty");
        romans.put("XC", "dziewięćdziesiąty");
        ROMAN_ORDINALS = Collections.unmodifiableMap(romans);

        Map<String, String[]> plurals = new HashMap<>();
        plurals.put("milion", new String[] {"milion", "miliony", "milionów"});
        plurals.put("tysiąc", new String[] {"tysiąc", "tysiące", "tysięcy"});
        plurals.put("miliard", new String[] {"miliard", "miliardy", "miliardów"});
        plurals.put("frank", new String[] {"frank", "franki", "franków"});
        plurals.put("centym", new String[] {"centym", "centymy", "centymów"});
        PLURALS = Collections.unmodifiableMap(plurals);

        Map<Integer, String> teens = new HashMap<>();
        teens.put(10, "dziesięć");
        teens.put(11, "jedenaście");
        teens.put(12, "dwanaście");
        teens.put(13, "trzynaście");
        teens.put(14, "czternaście");
        teens.put(15, "piętnaście");
        teens.put(16, "szesnaście");
        teens.put(17, "siedemnaście");
        teens.put(18, "osiemnaście");
        teens.put(19, "dziewiętnaście");
        TEENS = Collections.unmodifiableMap(teens);

        Map<Integer, String> tens = new HashMap<>();
        tens.put(1, "dziesięć");
        tens.put(2, "dwadzieścia");
        tens.put(3, "trzydzieści");
        tens.put(4, "czterdzieści");
        tens.put(5, "pięćdziesiąt");
        tens.put(6, "sześćdziesiąt");
        tens.put(7, "siedemdziesiąt");
        tens.put(8, "osiemdziesiąt");
        tens.put(9, "dziewięćdziesiąt");
        TENS = Collections.unmodifiableMap(tens);

        Map<Integer, String> ones = new HashMap<>();
        ones.put(1, "jeden");
        ones.put(2, "dwa");
        ones.put(3, "trzy");
        ones.put(4, "cztery");
        ones.put(5, "pięć");
        ones.put(6, "sześć");
        ones.put(7, "siedem");
        ones.put(8, "osiem");
        ones.put(9, "dziewięć");
        ONES = Collections.unmodifiableMap(ones);

        Map<Integer, String> teens_ord = new HashMap<>();
        teens_ord.put(10, "dziesiąty");
        teens_ord.put(11, "jedenasty");
        teens_ord.put(12, "dwunasty");
        teens_ord.put(13, "trzynasty");
        teens_ord.put(14, "czternasty");
        teens_ord.put(15, "piętnasty");
        teens_ord.put(16, "szesnasty");
        teens_ord.put(17, "siedemnasty");
        teens_ord.put(18, "osiemnasty");
        teens_ord.put(19, "dziewiętnasty");
        TEENS_ORD = Collections.unmodifiableMap(teens_ord);

        Map<Integer, String> ones_ord = new HashMap<>();
        ones_ord.put(1, "pierwszy");
        ones_ord.put(2, "drugi");
        ones_ord.put(3, "trzeci");
        ones_ord.put(4, "czwarty");
        ones_ord.put(5, "piąty");
        ones_ord.put(6, "szósty");
        ones_ord.put(7, "siódmy");
        ones_ord.put(8, "ósmy");
        ones_ord.put(9, "dziewiąty");
        ONES_ORD = Collections.unmodifiableMap(ones_ord);

        Map<String, String> card_to_ord = new HashMap<>();
        card_to_ord.put("jeden", "pierwszy");
        card_to_ord.put("dwa", "drugi");
        card_to_ord.put("trzy", "trzeci");
        card_to_ord.put("cztery", "czwarty");
        card_to_ord.put("pięć", "piąty");
        card_to_ord.put("sześć", "szósty");
        card_to_ord.put("siedem", "siódmy");
        card_to_ord.put("osiem", "ósmy");
        card_to_ord.put("dziewięć", "dziewiąty");
        card_to_ord.put("dziesięć", "dziesiąty");
        card_to_ord.put("jedenaście", "jedenasty");
        card_to_ord.put("dwanaście", "dwunasty");
        card_to_ord.put("trzynaście", "trzynasty");
        card_to_ord.put("czternaście", "czternasty");
        card_to_ord.put("piętnaście", "piętnasty");
        card_to_ord.put("szesnaście", "szesnasty");
        card_to_ord.put("siedemnaście", "siedemnasty");
        card_to_ord.put("osiemnaście", "osiemnasty");
        card_to_ord.put("dziewiętnaście", "dziewiętnasty");
        card_to_ord.put("dwadzieścia", "dwudziesty");
        card_to_ord.put("trzydzieści", "trzydziesty");
        card_to_ord.put("czterdzieści", "czterdziesty");
        card_to_ord.put("pięćdziesiąt", "pięćdziesiąty");
        card_to_ord.put("sześćdziesiąt", "sześćdziesiąty");
        card_to_ord.put("siedemdziesiąt", "siedemdziesiąty");
        card_to_ord.put("osiemdziesiąt", "osiemdziesiąty");
        card_to_ord.put("dziewięćdziesiąt", "dziewięćdziesiąty");
        CARD_TO_ORD = Collections.unmodifiableMap(card_to_ord);
    }

    public static String inflectOrdinal(String ordinal, String gender, String gcase) {
        if(gender == null || gender.equals("")) {
            gender = "m";
        }
        if(gcase == null || gcase.equals("")) {
            gcase = "nom";
        }

        if(gender.equals("m")) {
            if(gcase.equals("nom") || gcase.equals("voc")) {
                return ordinal;
            } else if (gcase.equals("loc") || gcase.equals("ins")) {
                return ordinal + "m";
            } else if (gcase.equals("gen")) {
                String mod = ordinal;
                if(ordinal.endsWith("y")) {
                    mod = ordinal.substring(0, ordinal.length() - 1);
                }
                return mod + "ego";
            }
        } else if(gender.equals("f")) {
            String mod = ordinal;
            if(ordinal.endsWith("y") || ordinal.endsWith("gi")) {
                mod = ordinal.substring(0, ordinal.length() - 1);
            }
            if(gcase.equals("nom") || gcase.equals("voc")) {
                return mod + "a";
            } else if (gcase.equals("acc") || gcase.equals("ins")) {
                return mod + "ą";
            } else {
                return mod + "ej";
            }
        }
        return ordinal;
    }
    public static String inflectOrdinal(String ordinal, String gender) {
        return inflectOrdinal(ordinal, gender, null);
    }
    public static String inflectOrdinal(String ordinal) {
        return inflectOrdinal(ordinal, null, null);
    }

}
