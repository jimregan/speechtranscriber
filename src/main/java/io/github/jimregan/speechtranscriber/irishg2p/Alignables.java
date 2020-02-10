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
package io.github.jimregan.speechtranscriber.irishg2p;

import java.util.ArrayList;
import java.util.List;

public class Alignables {
    static {
        List<G2PPiece> commonPieces = new ArrayList<>();
        commonPieces.add(new ShortVowel("a", "a"));
        commonPieces.add(new ShortVowel("ea", "a"));
        commonPieces.add(new ShortVowel("ai", "a"));
        commonPieces.add(new ShortVowel("eai", "a"));
        commonPieces.add(new ShortVowel("e", "e"));
        commonPieces.add(new ShortVowel("ei", "e"));
        commonPieces.add(new ShortVowel("ue", "e"));
        commonPieces.add(new ShortVowel("i", "i"));
        commonPieces.add(new ShortVowel("io", "i"));
        commonPieces.add(new ShortVowel("ui", "i"));
        commonPieces.add(new ShortVowel("o", "o"));
        commonPieces.add(new ShortVowel("oi", "o"));
        commonPieces.add(new ShortVowel("u", "u"));
        commonPieces.add(new ShortVowel("iu", "u"));
        commonPieces.add(new LongVowel("á", "aː"));
        commonPieces.add(new LongVowel("eá", "aː"));
        commonPieces.add(new LongVowel("ái", "aː"));
        commonPieces.add(new LongVowel("eái", "aː"));
        commonPieces.add(new LongVowel("é", "eː"));
        commonPieces.add(new LongVowel("éa", "eː"));
        commonPieces.add(new LongVowel("éi", "eː"));
        commonPieces.add(new LongVowel("ae", "eː"));
        commonPieces.add(new LongVowel("aei", "eː"));
        commonPieces.add(new LongVowel("í", "iː"));
        commonPieces.add(new LongVowel("aí", "iː"));
        commonPieces.add(new LongVowel("uí", "iː"));
        commonPieces.add(new LongVowel("oí", "iː"));
        commonPieces.add(new LongVowel("aoi", "iː"));
        // kinda Ulster, but no instances from abair
        // added as LongVowels there
        commonPieces.add(new Diphthong("ío", "iː", "iˑə"));
        commonPieces.add(new Diphthong("uío", "iː", "iˑə"));
        commonPieces.add(new Diphthong("aío", "iː", "iˑə"));
        // Ulster has reduction here
        commonPieces.add(new LongVowel("ó", "oː"));
        commonPieces.add(new LongVowel("ió", "oː"));
        commonPieces.add(new LongVowel("eó", "oː"));
        commonPieces.add(new LongVowel("eo", "oː"));
        commonPieces.add(new LongVowel("ói", "oː"));
        commonPieces.add(new LongVowel("eói", "oː"));
        commonPieces.add(new LongVowel("eoi", "oː"));
        // possible reduction in Ulster?
        commonPieces.add(new LongVowel("ú", "uː"));
        commonPieces.add(new LongVowel("iú", "uː"));
        commonPieces.add(new LongVowel("úi", "uː"));
        commonPieces.add(new LongVowel("iúi", "uː"));
        commonPieces.add(new LongVowel("úai", "uː"));
        // not Ulster - but Munster?
        commonPieces.add(new LongVowel("omh", "uː"));
        // Not Ulster
        commonPieces.add(new Diphthong("adh", "ai", "ə"));
        commonPieces.add(new Diphthong("adha", "ai", "ə"));
        commonPieces.add(new Diphthong("adhai", "ai", "ə"));
        commonPieces.add(new Diphthong("eadh", "ai", "ə"));
        commonPieces.add(new Diphthong("eadhai", "ai", "ə"));
        commonPieces.add(new Diphthong("agh", "ai", "ə"));
        commonPieces.add(new Diphthong("agha", "ai", "ə"));
        commonPieces.add(new Diphthong("aghai", "ai", "ə"));
        // Not Munster
        commonPieces.add(new Diphthong("oidh", "ai", "ə"));
        commonPieces.add(new Diphthong("oigh", "ai", "ə"));
        // Not Ulster
        commonPieces.add(new Diphthong("eighea", "ai", "ə"));
        commonPieces.add(new Diphthong("aidh", "ai", "ə"));
        // Not Munster
        commonPieces.add(new Diphthong("igh", "ai", "ə"));

        commonPieces.add(new Diphthong("abh", "au", "ə"));
        commonPieces.add(new Diphthong("eabh", "au", "ə"));
        commonPieces.add(new Diphthong("abha", "au", "ə"));
        commonPieces.add(new Diphthong("abhai", "au", "ə"));
        commonPieces.add(new Diphthong("eabha", "au", "ə"));
        commonPieces.add(new Diphthong("eabhai", "au", "ə"));
        commonPieces.add(new Diphthong("amha", "au", "ə"));
        commonPieces.add(new Diphthong("amhai", "au", "ə"));
        commonPieces.add(new Diphthong("eamha", "au", "ə"));
        commonPieces.add(new Diphthong("eamhai", "au", "ə"));
        commonPieces.add(new Diphthong("ogh", "au", "ə"));
        commonPieces.add(new Diphthong("ogha", "au", "ə"));
        commonPieces.add(new Diphthong("odh", "au", "ə"));
        commonPieces.add(new Diphthong("odha", "au", "ə"));
        commonPieces.add(new Diphthong("obha", "au", "ə"));
        commonPieces.add(new Diphthong("obhai", "au", "ə"));
        commonPieces.add(new Diphthong("ua", "uˑə"));
        commonPieces.add(new Diphthong("uai", "uˑə"));
        commonPieces.add(new Diphthong("iuai", "uˑə"));
        commonPieces.add(new Diphthong("ia", "iˑə"));
        commonPieces.add(new Diphthong("iai", "iˑə"));
        try {
            commonPieces.add(new LongVowelPair("i á", "iː aː"));
            commonPieces.add(new LongVowelPair("i ái", "iː aː"));
            commonPieces.add(new LongVowelPair("u á", "uː aː"));
            commonPieces.add(new LongVowelPair("u ái", "uː aː"));
            commonPieces.add(new LongVowelPair("iu á", "uː aː"));
            commonPieces.add(new LongVowelPair("iu ái", "uː aː"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        commonPieces.add(new Consonant("b", "bˠ", "bʲ"));
        commonPieces.add(new Consonant("c", "k", "c"));
        commonPieces.add(new Consonant("f", "fˠ", "fʲ"));
        commonPieces.add(new Consonant("g", "ɡ", "ɟ"));
        commonPieces.add(new Consonant("k", "k", "c"));
        commonPieces.add(new Consonant("q", "k", "c"));
        commonPieces.add(new Consonant("p", "pˠ", "pʲ"));
        // devoicings
        commonPieces.add(new Consonant("b", "pˠ", "pʲ", "f(?:á|eá|a?í)$"));
        commonPieces.add(new Consonant("d", "t̪ˠ", "tʲ", "f(?:á|eá|a?í)$"));
        commonPieces.add(new Consonant("g", "k", "c", "f(?:á|eá|a?í)$"));

        List<G2PPiece> piecesMU = new ArrayList<>();
        piecesMU.add(new LongVowel("a", "au", "(?:ll|nn?|rr)(?:[bcdfghjklmnpqrstvwxyz]+)?$"));
        piecesMU.add(new LongVowel("ea", "au", "(?:ll|nn?|rr)(?:[bcdfghjklmnpqrstvwxyz]+)?$"));
        piecesMU.add(new LongVowel("i", "iː", "nn(?:[bcdfghjklmnpqrstvwxyz]+)?$"));
        piecesMU.add(new LongVowel("io", "u", "(?:nn?|p)(?:[bcdfghjklmnpqrstvwxyz]+)?$"));
        piecesMU.add(new LongVowel("o", "oː", "(?:ll|nn)(?:[bcdfghjklmnpqrstvwxyz]+)?$"));
        piecesMU.add(new LongVowel("o", "iː", "(?:ll|nn)(?:[bcdfghjklmnpqrstvwxyz]+)?$"));
        piecesMU.add(new LongVowel("éa", "iː", "^(?:dh?|n)"));
        piecesMU.add(new LongVowel("ao", "eː"));
        // Corca Dhuibhne
        piecesMU.add(new LongVowel("uibh", "iː"));
        piecesMU.add(new LongVowel("uimh", "iː"));
        piecesMU.add(new LongVowel("uibhe", "iː", "$"));
        piecesMU.add(new LongVowel("uimhe", "iː", "$"));
        try {
            piecesMU.add(new MaybeDiphthong("oi dh", "ai", "i ɟ"));
            piecesMU.add(new MaybeDiphthong("oi gh", "ai", "i ɟ"));
            piecesMU.add(new MaybeDiphthong("ei dh", "ai", "ə ɟ"));
            piecesMU.add(new MaybeDiphthong("ai gh", "ai", "i ɟ"));
            piecesMU.add(new MaybeDiphthong("i dh", "ai", "i ɟ"));
            piecesMU.add(new MaybeDiphthong("i gh", "ai", "i ɟ"));
            piecesMU.add(new MaybeDiphthong("a mh", "au", "ə vˠ"));
            piecesMU.add(new MaybeDiphthong("ea mh", "au", "ə vˠ"));

            piecesMU.add(new LongVowelPair("i á", "i aː"));
            piecesMU.add(new LongVowelPair("i ái", "i aː"));
            piecesMU.add(new LongVowelPair("u á", "u aː"));
            piecesMU.add(new LongVowelPair("u ái", "u aː"));
            piecesMU.add(new LongVowelPair("iu á", "u aː"));
            piecesMU.add(new LongVowelPair("iu ái", "u aː"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        List<G2PPiece> piecesCO = new ArrayList<>();
        piecesCO.add(new LongVowel("a", "au", "(?:ll|nn|rr)(?:[bcdfghjklmnpqrstvwxyz]+)?$"));
        piecesCO.add(new LongVowel("ea", "au", "(?:ll|nn|rr)(?:[bcdfghjklmnpqrstvwxyz]+)?$"));
        piecesCO.add(new LongVowel("i", "iː", "nn(?:[bcdfghjklmnpqrstvwxyz]+)?$"));
        piecesCO.add(new LongVowel("io", "u", "(?:nn?|p)(?:[bcdfghjklmnpqrstvwxyz]+)?$"));
        piecesCO.add(new LongVowel("o", "o", "(?:ll|nn|r)(?:[bcdfghjklmnpqrstvwxyz]+)?$"));
        piecesCO.add(new LongVowel("o", "iː", "(?:ll|nn|r)(?:[bcdfghjklmnpqrstvwxyz]+)?$"));
        piecesCO.add(new LongVowel("éa", "iː", "^(?:dh?|n)"));
        piecesCO.add(new LongVowel("ao", "iː"));
        piecesCO.add(new Diphthong("eidh", "ai", "ə"));
        piecesCO.add(new Diphthong("aigh", "ai", "ə"));
        piecesCO.add(new Diphthong("idh", "ai", "ə"));
        piecesCO.add(new Diphthong("amh", "au", "ə"));
        piecesCO.add(new Diphthong("eamh", "au", "ə"));

        List<G2PPiece> piecesUL = new ArrayList<>();
        piecesUL.add(new LongVowel("o", "oː", "r(?:[bcdfghjklmnpqrstvwxyz]+)?$"));
        piecesUL.add(new LongVowel("ao", "iː"));
        piecesUL.add(new LongVowel("ío", "iː"));
        piecesUL.add(new LongVowel("uío", "iː"));
        piecesUL.add(new LongVowel("aío", "iː"));
        piecesUL.add(new RLongVowel("ó", "oː", "o"));
        piecesUL.add(new RLongVowel("ió", "oː", "o"));
        piecesUL.add(new RLongVowel("eó", "oː", "o"));
        piecesUL.add(new RLongVowel("eo", "oː", "o"));
        piecesUL.add(new RLongVowel("ói", "oː", "o"));
        piecesUL.add(new RLongVowel("eoi", "oː", "o"));
        piecesUL.add(new LongVowel("omh", "oː"));
        piecesUL.add(new LongVowel("omh", "uː", "$"));
        piecesUL.add(new LongVowel("omh", "uː", "[^a-záéíóú].*$"));
        piecesUL.add(new RLongVowel("adh", "iː", "uː"));
        piecesUL.add(new LongVowel("adha", "iː"));
        piecesUL.add(new LongVowel("adhai", "iː"));
        piecesUL.add(new RLongVowel("eadh", "iː", "uː"));
        piecesUL.add(new LongVowel("eadhai", "iː"));
        piecesUL.add(new RLongVowel("agh", "eː", "ə"));
        piecesUL.add(new LongVowel("agha", "eː"));
        piecesUL.add(new LongVowel("aghai", "eː"));
        piecesUL.add(new RLongVowel("eidh", "eː", "ə"));
        piecesUL.add(new RLongVowel("eighea", "eː", "ə"));
        piecesUL.add(new RLongVowel("aidh", "eː", "iː"));
        piecesUL.add(new RLongVowel("aigh", "eː", "iː"));
        piecesUL.add(new LongVowel("idh", "iː"));
        piecesUL.add(new Diphthong("igh", "ai", "ə"));
        piecesUL.add(new Diphthong("eabh", "au", "uː"));
        piecesUL.add(new Diphthong("amh", "au", "uː"));
        piecesUL.add(new Diphthong("eamh", "au", "uː"));
        piecesUL.add(new Diphthong("odh", "au", "uː"));
    }
}
