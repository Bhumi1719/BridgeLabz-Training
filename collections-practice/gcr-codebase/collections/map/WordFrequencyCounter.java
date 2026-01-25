import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequencyCounter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Integer> wordMap = new HashMap<>();

        System.out.print("Enter text: ");
        String input = sc.nextLine();

        // ignore case and punctuation
        input = input.toLowerCase().replaceAll("[^a-z ]", "");

        String[] words = input.split("\\s+");

        for(String word : words) {
            if(!word.isEmpty()) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }

        System.out.println(wordMap);
    }
}
