package code.problems.string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWords {
    public static void main(String[] args) {
//        System.out.println(reverseWords("the sky is blue"));
//        System.out.println(reverseWords("a good   example"));
    }
    public static String reverseWords(String s) {
        String[] words = s.split("\\s");
        words = Arrays.stream(words)
                .filter(word -> !word.isEmpty())
                .toList().toArray(new String[0]);
        for(int i=0, j=words.length-1; i<j;){
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;j--;
        }
        // return Arrays.stream(words).collect(Collectors.joining(" "));
        return String.join(" ", words);
    }
}
