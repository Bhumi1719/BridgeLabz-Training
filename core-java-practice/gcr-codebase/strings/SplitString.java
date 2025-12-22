import java.util.*;

public class SplitString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String str = sc.nextLine();

        String[] noMethod = splitString(str); // Array of words without using method
        String[] methodSplit = str.split(" "); // Array of words using split method

        boolean isEqual = areEqual(noMethod, methodSplit); // Calling comparing function and storing in boolean type variable

        System.out.println("Words without using in-built method: ");
        for (String word : noMethod) {
            System.out.println(word);
        }

        System.out.println("\nWords using built-in split method: ");
        for (String word : methodSplit) {
            System.out.println(word);
        }

        System.out.println("\nAre both Strings equal? " + isEqual);
    }

    // Method to find the length of string without using in-built function
    public static int findLength(String name) {
        int COUNT = 0; // COunter to track the length of the string

        // Infinte while loop to find the length with a try and catch block
        while(true) {
            try { 
                name.charAt(COUNT);
                COUNT ++; // Increamenting the counter for each iteration
            } catch(StringIndexOutOfBoundsException e) { // Catch block for exception if the counter exceeds the length of the string and terminates the loop
                break;
            }
        }

        return COUNT; // Return an integer for the method
    }

    // Method to split the string without using the in-built method
    public static String[] splitString(String name) {
        int length = findLength(name); // Calling the length mehtod and storing it in a variable

        int SPACE = 1;
        for(int i=0; i<length; i++) { // Loop to find the length of spaces in the string
            if(name.charAt(i) == ' ') {
                SPACE ++; // Increamenting the space variable for each iteration
            }
        }

        // Declaring an array of size space - 1 for storing the index of the spaces in the string
        int[] spaces = new int[SPACE - 1];
        int COUNTER = 0;
        for(int i=0; i<length; i++) {
            if(name.charAt(i) == ' '){
                spaces[COUNTER ++] = i;
            }
        }

        // Declaring an array for storing the words without spaces
        String[] word = new String[SPACE];
        int START_INDEX = 0; // Initialzing an index
        for(int i=0; i <spaces.length; i++) {
            word[i] = name.substring(START_INDEX, spaces[i]); // Splitiing the words by using substring method forf each space
            START_INDEX = spaces[i] + 1;
        }
        word[SPACE - 1] = name.substring(START_INDEX);

        return word; // Returning an array of words
    }
 
    // Method for comparing both the strings with or without the aplit method
    public static boolean areEqual(String[] name1, String[] name2) {
        if (name1.length != name2.length) { // Comparing the length
            return false;
        }

        for (int i=0; i<name1.length; i++) { // Comparing the words of the arrays
            if (!name1[i].equals(name2[i]))
                return false;
        }

        return true;
    }
}