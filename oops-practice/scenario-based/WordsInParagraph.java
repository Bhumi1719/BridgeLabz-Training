import java.util.*;

public class WordsInParagraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a paragraph: ");
        String paragraph = sc.nextLine();

        System.out.print("Enter the word to replace: ");
        String wordToReplace = sc.nextLine();

        System.out.print("Enter the new word: ");
        String newWord = sc.nextLine();

        analyzeParagraph(paragraph, wordToReplace, newWord); // Calling the method directly as print statement is inside the method only
    }

    // Creating a method to analyze the given paragraph
    public static void analyzeParagraph(String paragraph, String wordToReplace, String newWord) {
        if (paragraph == null || paragraph.trim().isEmpty()) { // Condition for checking empty or space-only input
            System.out.println("Paragraph is empty or contains only spaces.");
            return;
        }

        // For trimming extra spaces
        paragraph = paragraph.trim();

        // For splitting words
        String[] words = paragraph.split("\\s+");

        // For counting words in the paragraph
        final int WORD_COUNT = words.length;
        System.out.println("The number of words in the paragraph are: " + WORD_COUNT);

        String longest = words[0]; // Variable to store the longest word in paragraph

        // Loop for finding the longest word in the paragraph
        for(String word : words) {
            if(word.length() > longest.length()) {
                longest = word;
            }
        }

        System.out.println("Longest Word in the paragraph is: " + longest);
        // For replacing the word(case-insensitive)
        String replaceWord = paragraph.replaceAll("(?i)\\b" + wordToReplace + "\\b", newWord);
        
        System.out.println("\nParagraph after making changes is:");
        System.out.println(replaceWord);
    }
}