package io.github.jimregan.polishtranscriber;

import java.io.InputStream;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import edu.cmu.sphinx.decoder.adaptation.Stats;
import edu.cmu.sphinx.decoder.adaptation.Transform;
import edu.cmu.sphinx.result.WordResult;

public class Transcriber {
    Configuration cfg;
    StreamSpeechRecognizer rec;
    SpeechResult res;
    Transcriber() throws Exception {
        cfg = new Configuration();
        cfg.setAcousticModelPath("resource:/io/github/jimregan/cmusphinx-clarinpl/");
        cfg.setDictionaryPath("resource:/io/github/jimregan/cmusphinx-clarinpl/pl.dic");
        cfg.setLanguageModelPath("resource:/io/github/jimregan/cmusphinx-clarinpl/pl.lm.DMP");
        rec = new StreamSpeechRecognizer(cfg);
    }
}
