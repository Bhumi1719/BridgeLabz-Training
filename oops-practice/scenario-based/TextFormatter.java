import java.util.*;

public class TextFormatter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the sentence: ");
        String sentence = sc.nextLine();

        System.out.println(formatParagraph(sentence)); // Calling the method
    }

    // Creating a method for auto-correcting paragraph formatting
    public static String formatParagraph(String paragraph) {
        // For trimming leading and trailing spaces
        paragraph = paragraph.trim();

        // For replacing multiple spaces with a single space
        paragraph = paragraph.replaceAll("\\s+", " ");

        // For putting one space after punctuation
        paragraph = paragraph.replaceAll("([.!?])\\s*", "$1 ");

        // Creating a stringbuilder for storing the resulant paragraph
        StringBuilder result = new StringBuilder();

        // Creating a variable to track that first letter is capital for each sentence
        boolean NEXT_CAPITAL = true;

        // Loop for capitalizing first letter of each sentence
        for(char character : paragraph.toCharArray()) {
            if(NEXT_CAPITAL && Character.isLetter(character)) {
                result.append(Character.toUpperCase(character));
                NEXT_CAPITAL = false;
            } else {
                result.append(character); // Adding the character to the string builder
            }

            if(character == '.' || character == '!' || character == '?') { // Checking for punctuations
                NEXT_CAPITAL = true;
            }
        }

        return result.toString().trim(); // Returning a string converted from the string builder and trim it 
    }
}
