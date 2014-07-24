package net.ahjota.praxis.markvshaney;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A MarkVShaney implementation that gives equal weighting to each possible future state
 * in the Markov chain. In other words, the frequency with which a word triple appears in
 * the training text has no bearing on how often that triple appears in any generated Shaneys.
 *
 * @author ajalon
 */
public class EqualProbabilitiesShaney implements MarkVShaney {

    /**
     * key  String representing two words separated by a '/t' tab char
     * val  List of Strings representing all possible
     */
    Map<String, List<String>> equalProbabilitiesMarkov = new HashMap<String, List<String>>();

    public static void main(String[] args) {
        MarkVShaney epShaney = new EqualProbabilitiesShaney(null);
        System.out.println(epShaney.generate(50));
    }

    public EqualProbabilitiesShaney(Reader trainingText) {
        this.train(trainingText);
    }

    @Override
    public void train(Reader is) {
        if (is == null) {
            throw new IllegalArgumentException("input reader cannot be null");
        }

        equalProbabilitiesMarkov.clear();
    }

    @Override
    public String generate(int wordCount) throws IllegalStateException {
        return null;
    }
}
