package net.ahjota.praxis.wordfreqs;

import java.io.Reader;
import java.util.HashMap;

/**
 * Write a program that takes a filename and a parameter n and prints the n
 * most common words in the file, and the count of their occurrences, in
 * descending order.
 *
 * @author ajalon
 * @see <http://programmingpraxis.com/2009/03/10/word-frequencies/>
 * http://programmingpraxis.com/2009/03/10/word-frequencies/</a>
 */
public class WordCounter {

    public static void main(String[] args) {

    }

    /**
     * @param in reader
     * @param n  number of most common words to print
     */
    public void printMostCommonWords(Reader in, int n) {

    }

    private WordFrequencyCount countWordFrequencies(Reader in, int n) {
        return null;
    }

    private class WordFrequencyCount {

        HashMap<String, Integer> frequencyMap;

        private WordFrequencyCount() {

        }

        private WordFrequencyCount(int n) {
            frequencyMap = new HashMap<String, Integer>(n);
        }

        int frequency(String word) {

        }

        void add(String word) {

        }

        void remove(String word) {

        }

        void reset() {
            frequencyMap.clear();
        }
    }
}
