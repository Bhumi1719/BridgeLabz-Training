import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file path: ");
        String filePath = sc.nextLine();

        File file = new File(filePath);
        if(!file.exists()) {
            System.out.println("File does not exist: " + filePath);
            return;
        }

        Map<String, Integer> wordCount = new HashMap<>();
        int totalWords = 0;

        try(
            FileReader fr = new FileReader(file, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(fr)
        ) {
            String line;

            while((line = br.readLine()) != null) {

                // Removing punctuation and convert to lowercase
                line = line.toLowerCase().replaceAll("[^a-z0-9 ]", " ");

                String[] words = line.split("\\s+");

                for(String word : words) {
                    if(!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                        totalWords++;
                    }
                }
            }

        } catch(IOException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }

        // Sort words by frequency (descending)
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());

        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("\nTotal Words: " + totalWords);
        System.out.println("Top 5 Most Frequent Words:");

        for(int i = 0; i < Math.min(5, sortedList.size()); i++) {
            Map.Entry<String, Integer> entry = sortedList.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " = " + entry.getValue());
        }
    }
}
