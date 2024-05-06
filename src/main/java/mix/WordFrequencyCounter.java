package mix;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String text = "Java is a programming language. Java is widely used for developing various applications.";
        text = "This is a sample text. The text may contain words, punctuation, and spaces. This sample text is for testing";
        // Split the text into words, convert to lowercase, and collect into a map with word counts
        Map<String, Long> wordFrequencyMap = Arrays.stream(text.toLowerCase().split("\\s+"))
                .map(inputString -> inputString.replaceAll("[^a-zA-Z0-9\\s]", ""))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        // Sort the map entries by value in descending order, and if counts are the same, sort by key (word) alphabetically
        wordFrequencyMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
