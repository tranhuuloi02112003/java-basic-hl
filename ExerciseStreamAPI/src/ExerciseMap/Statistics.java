package ExerciseMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Statistics {

    public static Map<String, Integer> countWords(String text) {
        if (text == null || text.isEmpty()) {
            return Collections.emptyMap();
        }
        Map<String, Integer> wordCountMap = new HashMap<>();

        String[] words = text.toLowerCase().split("\\W+");
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        return wordCountMap;
    }

    public static String findMostCommonWord(Map<String, Integer> wordCountMap) {
        if (wordCountMap.isEmpty()) {
            return "No words found.";
        }

        String mostCommonWord = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommonWord = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return "Word: " + mostCommonWord + ", Count: " + maxCount + " times.";
    }

    public static void main(String[] args) {
        String inputText = "Apple   apple  banana apple! Banana, ? Orange.";

        Map<String, Integer> wordCountMap = countWords(inputText);

        System.out.println("Word Frequencies:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nMost Common Word:");
        String mostCommon = findMostCommonWord(wordCountMap);
        System.out.println(mostCommon);
    }
}
