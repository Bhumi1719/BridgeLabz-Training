import java.util.*;

public class UniqueCharFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String name = sc.nextLine();

        String[][] result = findFrequency(name);

        System.out.println("Character\tFrequency");
        for(int i=0; i<result.length; i++) {
            System.out.println(result[i][0] + "\t\t" + result[i][1]);
        }
    }

    public static char[] findUniqueCharacters(String name) {
        char[] temp = new char[name.length()]; // Creating a new char array with length calculated using length function
        int UNIQUE_COUNT = 0;

        // Loop for finding the unique characters in a string
        for(int i=0; i<name.length(); i++) {
            char ch = name.charAt(i); // Storing character one by one in a variable 
            boolean IS_UNIQUE = true; // Creating a boolean variable and initialising it to true

            for(int j=0; j<i; j++) {
                if(ch == name.charAt(j)) { // Checking if ch is same as the character visited or not
                    IS_UNIQUE = false; // If same then make the boolean variable false and break the loop
                    break;
                }
            }

            if(IS_UNIQUE) { // If the character is unique then this if block will execute
                temp[UNIQUE_COUNT ++] = ch;
            }
        }

        // Creating exact-sized array for unique characters
        char[] unique = new char[UNIQUE_COUNT];
        for(int i=0; i<UNIQUE_COUNT; i++) {
            unique[i] = temp[i]; // Storing the elements of temp array to unique array
        }

        return unique;
    }
    
    // Method to find frequency using unique characters
    public static String[][] findFrequency(String name) {
        int[] frequency = new int[256]; // Creating an array ASCII characters

        // Loop for counting the frequency of each character in the string
        for(int i=0; i<name.length(); i++) {
            char character = name.charAt(i);
            frequency[character] ++; // Increasing the frequency of the element that occured
        }

        int UNIQUE_COUNT = 0; // Variable to keep track of unique characters
        // Loop for counting the unique characters
        for(int i=0; i<256; i++) {
            if(frequency[i] > 0) { // Conditional for checking if the frequency is greater than 0
                UNIQUE_COUNT ++; // If there is any element with frequency > 0 then increasing the counter variable
            }
        }

        // Calling the function for finding the unique characters and storing it in an array
        char[] unique = findUniqueCharacters(name);

        // Storing the result in 2D array
        String[][] result = new String[unique.length][2]; // 2 one for unique character and other for frequency

        for(int i=0; i<unique.length; i++) { 
            result[i][0] = String.valueOf(unique[i]); // Storing the uniques characters
            result[i][1] = String.valueOf(frequency[unique[i]]); // Storing the frequency
        }
        return result;
    }
}
