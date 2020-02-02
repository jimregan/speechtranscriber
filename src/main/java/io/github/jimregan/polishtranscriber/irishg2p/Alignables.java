package io.github.jimregan.polishtranscriber.irishg2p;

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
        piecesMU.add(new Diphthong("oidh", "ai", "i ɟ"));
        piecesMU.add(new Diphthong("oigh", "ai", "i ɟ"));
        piecesMU.add(new Diphthong("eidh", "ai", "ə ɟ"));
        piecesMU.add(new Seq("oidh", new G2PPiece[]{new ShortVowel("oi", null, "i"), new Consonant("dh", null, "ɟ")}, "$"));
        piecesMU.add(new Seq("oigh", new G2PPiece[]{new ShortVowel("oi", null, "i"), new Consonant("gh", null, "ɟ")}, "$"));
        piecesMU.add(new Seq("eidh", new G2PPiece[]{new ShortVowel("ei", null, "i"), new Consonant("dh", null, "ɟ")}, "$"));

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
        piecesCO.add(new RLongVowel("eidh", "eː", "ə"));
        piecesCO.add(new RLongVowel("eighea", "eː", "ə"));
    }
}
