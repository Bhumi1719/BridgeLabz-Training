import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a paragraph:");
        String paragraph = sc.nextLine();

        // Converting paragraph into words
        Map<String, Integer> wordFrequency = Arrays.stream(paragraph.toLowerCase().split("\\W+"))
                        .collect(Collectors.toMap(
                                Function.identity(), 
                                word -> 1,          // initial value
                                Integer::sum        // merging function for duplicates
                        ));

        System.out.println("\nWord Frequency");

        wordFrequency.forEach((word, count) -> System.out.println(word + " -> " + count));
    }
}
