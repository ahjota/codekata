package net.ahjota.praxis.wordfreqs;

import org.apache.maven.surefire.shade.org.codehaus.plexus.util.StringUtils;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

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
        Path path = FileSystems.getDefault().getPath(args[0]);
        WordCounter wc = new WordCounter();
        wc.countWordFrequencies(path, Integer.valueOf(args[1]));
    }

    /**
     * @param in reader
     * @param n  number of most common words to print
     */
    public void printMostCommonWords(Reader in, int n) {

    }

    private void countWordFrequencies(Path file, int n) {
        boolean finished = false;
        WordFrequencyCount count = new WordFrequencyCount();

        try {
            List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);

            for (String line : lines) {
                if (StringUtils.isNotBlank(line)) {
                    String[] words = line
                            .trim()//remove leading/trailing whitespace
                            .replaceAll("\\p{Punct}", "")//remove punctuation
                            .replaceAll("\\p{javaWhitespace}{2,}", " ")//collapse whitespace
                            .split("\\p{javaWhitespace}");
                    for (String word : words) {
                        count.add(word.toLowerCase());
                    }
                }
            }

            ArrayList<Map.Entry<String, Integer>> freqs = new ArrayList<Map.Entry<String, Integer>>(count.entrySet());
            Collections.sort(freqs, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });

            if (freqs.size() < n) {
                n = freqs.size();
            }

            // FIXME
            for (int i=0; i<n; ++i) {
                Map.Entry<String, Integer> wordFreq = freqs.get(i);
                System.out.println(wordFreq.getKey() + "\t" + wordFreq.getValue());
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }


    }

private class WordFrequencyCount {

    HashMap<String, Integer> frequencyMap;

    WordFrequencyCount() {
        frequencyMap = new HashMap<String, Integer>();
    }

    int frequency(String word) {
        return frequencyMap.get(word);
    }

    void add(String word) {
        if (frequencyMap.containsKey(word)) {
            Integer freq = frequencyMap.get(word);
            frequencyMap.put(word, ++freq);
        } else {
            frequencyMap.put(word, 1);
        }
    }

    void remove(String word) {
        frequencyMap.remove(word);
    }

    Set<String> keySet() {
        return frequencyMap.keySet();
    }

    Set<Map.Entry<String, Integer>> entrySet() {
        return frequencyMap.entrySet();
    }

    void reset() {
        frequencyMap.clear();
    }
}
}
