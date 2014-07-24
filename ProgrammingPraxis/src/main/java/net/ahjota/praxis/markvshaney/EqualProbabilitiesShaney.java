package net.ahjota.praxis.markvshaney;

import java.io.*;
import java.util.*;

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
     * val  List of Strings representing all possible words following the two word key.
     */
    Map<String, List<String>> equalProbabilitiesMarkov = new HashMap<String, List<String>>();

    public static void main(String[] args) {
        MarkVShaney epShaney = null;

        if (args[0] != null) {
            String fileName = args[0];
            try {
                epShaney = new EqualProbabilitiesShaney(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                throw new IllegalArgumentException("File not found; exiting");
            }
        }

        if (args.length > 1) {
            for (String fileName : args) {

                try {
                    epShaney.train(new FileReader(fileName));
                } catch (FileNotFoundException e) {
                    System.out.println("Additional files not found");
                }
            }
        }

        if (epShaney != null) {
            System.out.println(epShaney.generate(100));
        }
    }

    public EqualProbabilitiesShaney(Reader trainingText) {
        this.train(trainingText);
    }

    @Override
    public void train(Reader reader) {
        if (reader == null) {
            throw new IllegalArgumentException("input reader cannot be null");
        }

        BufferedReader bReader;
        if (reader instanceof BufferedReader) {
            bReader = (BufferedReader) reader;
        } else {
            bReader = new BufferedReader(reader);
        }

        int nextChar = 0;
        try {
            StringBuilder sb = new StringBuilder();
            String token1 = null;
            String token2 = null;
            String token3 = null;

            boolean wasWhitespace = false;

            do {
                nextChar = bReader.read();
                if (Character.isWhitespace(nextChar)) {
                    if (wasWhitespace) continue;

                    // we've completed a new token.
                    // store token in token3, then add everything to the map.
                    token1 = token2;
                    token2 = token3;
                    token3 = sb.toString();

                    String key = createKey(token1, token2);
                    List<String> futureStates = retrieveFutureStates(key);
                    futureStates.add(token3);
//                    System.out.println(key + ":" + token3);

                    sb = new StringBuilder();
                    wasWhitespace = true;
                } else {
                    sb.append((char) nextChar);
                    wasWhitespace = false;
                }
            } while (nextChar > -1);
        } catch (IOException e) {
            throw new IllegalArgumentException("Unable to read file", e);
        }
    }

    private String createKey(String token1, String token2) {
        return (token1 + "/t" + token2);
    }

    private List<String> retrieveFutureStates(String currentStateKey) {
        List<String> futureStates;
        if (equalProbabilitiesMarkov.containsKey(currentStateKey)) {
            futureStates = equalProbabilitiesMarkov.get(currentStateKey);
        } else {
            futureStates = new ArrayList<String>();
            equalProbabilitiesMarkov.put(currentStateKey, futureStates);
        }

        return futureStates;
    }

    private boolean isTrained() {
        return !equalProbabilitiesMarkov.isEmpty();
    }

    @Override
    public void clearMarkovChain() {
        equalProbabilitiesMarkov.clear();
    }

    @Override
    public String generate(int wordCount) throws IllegalStateException {
        System.out.println("Generating text");

        if (!isTrained()) {
            throw new IllegalStateException("Unable to generate texts; Shaney has not been trained");
        }

        Random rng = new Random();

        StringBuilder sb = new StringBuilder();
        String word1 = null;
        String word2 = null;
        String key = createKey(word1, word2);
        String word3 = null;

        for (int count = 0; count < wordCount; ++count) {
            List<String> futureStates = equalProbabilitiesMarkov.get(key);
            System.out.println(key + ":" + futureStates);

            // choose one of the possible future states
            int nextFutureState = rng.nextInt(futureStates.size());
            word3 = futureStates.get(nextFutureState);

            sb.append(" ");
            sb.append(word3);

            word1 = word2;
            word2 = word3;
            key = createKey(word1, word2);
        }

        return sb.toString();
    }
}
