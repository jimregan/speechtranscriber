package io.github.jimregan.speechtranscriber.abair.corpus;

import java.util.ArrayList;
import java.util.List;

public class Syllable {
    int Stress;
    private String raw_stress = null;
    List<Phoneme> phonemes;
    public Syllable() {
        this.phonemes = new ArrayList<>();
    }
}
