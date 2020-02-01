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

        List<G2PPiece> piecesCO = new ArrayList<>();
        piecesCO.add(new LongVowel("a", "au", "(?:ll|nn|rr)(?:[bcdfghjklmnpqrstvwxyz]+)?$"));
        piecesCO.add(new LongVowel("ea", "au", "(?:ll|nn|rr)(?:[bcdfghjklmnpqrstvwxyz]+)?$"));
        piecesCO.add(new LongVowel("i", "iː", "nn(?:[bcdfghjklmnpqrstvwxyz]+)?$"));
        piecesCO.add(new LongVowel("io", "u", "(?:nn?|p)(?:[bcdfghjklmnpqrstvwxyz]+)?$"));
        piecesCO.add(new LongVowel("o", "o", "(?:ll|nn|r)(?:[bcdfghjklmnpqrstvwxyz]+)?$"));
        piecesCO.add(new LongVowel("o", "iː", "(?:ll|nn|r)(?:[bcdfghjklmnpqrstvwxyz]+)?$"));
        piecesCO.add(new LongVowel("éa", "iː", "^(?:dh?|n)"));
        piecesCO.add(new LongVowel("ao", "iː"));

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
    }
}
