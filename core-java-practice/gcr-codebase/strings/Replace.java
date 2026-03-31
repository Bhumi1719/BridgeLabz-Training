import java.util.*;

public class Replace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String name = sc.nextLine();

        System.out.print("Enter word to replace: ");
        String oldWord = sc.next();

        System.out.print("Enter the new word: ");
        String newWord = sc.next();

        System.out.println("The resultant string is: " + replaceWord(name, oldWord, newWord)); // Dirsctly calling the method and printing it
    }

    // Method to replace the word in the string
    public static String replaceWord(String name, String oldWord, String newWord) {
        // Converting the string into string array after splitting
        String[] words = name.split(" ");

        // Creating an empty string to store the result
        String replaceWords = "";

        // Loop to replace the word
        for(int i=0; i<words.length; i++) {
            if(words[i].equals(oldWord)) {
                replaceWords += newWord; // If old word is found then replace it
            } else {
                replaceWords += words[i]; // If not found then write the word as it is
            }

            if(i < words.length - 1) { // To add spaces between the words
                replaceWords += " ";
            }
        }
        return replaceWords;
    }
}
