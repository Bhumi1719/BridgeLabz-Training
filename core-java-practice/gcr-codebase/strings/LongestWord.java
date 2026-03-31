import java.util.*;

public class LongestWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String name = sc.nextLine();

        // Creating a string array with words of the string splitted
        String[] words = name.split(" ");

        // Creating en empty string
        String LARGEST_WORD = "";

        // Finding the length of words and comparing them
        for(String word : words) {
            if(word.length() > LARGEST_WORD.length()) {
                LARGEST_WORD = word;
            }
        }

        System.out.println("The largest word in the given string is: " + LARGEST_WORD);
    }
}