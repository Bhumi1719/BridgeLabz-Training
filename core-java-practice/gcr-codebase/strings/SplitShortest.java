import java.util.*;

public class SplitShortest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String str = sc.nextLine();

        String[] word = splitString(str); // Array of string without using in-built method
        String[][] wordLength = wordAndLength(word); // 2D array with both words and their length
        int[] shortAndLong = shortestAndLongest(wordLength); // Required 1D array 

        System.out.println("Shortest Word is  " + wordLength[shortAndLong[0]][0] + " with Length: " + wordLength[shortAndLong[0]][1]);

        System.out.println("Longest Word is " + wordLength[shortAndLong[1]][0] + " with Length: " + wordLength[shortAndLong[1]][1]);
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

    // Method to store the words with their length in 2D array
    public static String[][] wordAndLength(String[] word) {
        // Declaring a 2D array to store both words and length of words
        String[][] wordWithLength = new String[word.length][2];

        for (int i=0; i<word.length; i++) {
            wordWithLength[i][0] = word[i]; // Storing the words in the array
            wordWithLength[i][1] = String.valueOf(findLength(word[i])); // Finding the length and storing it
        }

        return wordWithLength; // Returning a 2D array with required results
    }

    // Method to find the words with shortest and longest length
    public static int[] shortestAndLongest(String[][] word) {
        int MIN_INDEX = 0; // For minimum index
        int MAX_INDEX = 0; // For maximum index

        for (int i=1; i<word.length; i++) {
            int length = Integer.parseInt(word[i][1]);
            int minLength = Integer.parseInt(word[MIN_INDEX][1]);
            int maxLength = Integer.parseInt(word[MAX_INDEX][1]);

            if (length < minLength)
                MIN_INDEX = i;
            if (length > maxLength)
                MAX_INDEX = i;
        }

        return new int[]{MIN_INDEX, MAX_INDEX}; // Returning a new 2D array with shortest and longest length
    }
}