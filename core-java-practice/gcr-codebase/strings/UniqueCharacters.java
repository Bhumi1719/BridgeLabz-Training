import java.util.*;

public class UniqueCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String name = sc.nextLine();

        char[] uniqueCharacters = findUniqueCharacters(name); // Calling the function for finding the unique characters and storing it in an array

        // Printing the result of array using for-each loop
        System.out.print("Unique characters in a string are: ");
        for(char ch : uniqueCharacters) {
            System.out.print(ch + " ");
        }
    }

    // Method for finding the length of string without using in-built method
    public static int findLength(String name) {
        int COUNT = 0; // Counter variable for keeping tracking of the string length

        // Try-catch block for handling the exception
        try {
            while (true) { // Infinite loop until the Counter exceeds the string length
                name.charAt(COUNT);
                COUNT ++; // Increamenting count for next iteratiion
            }
        } catch (IndexOutOfBoundsException e) { 
            
        }
        return COUNT;
    }

    // Method to find unique characters using charAt()
    public static char[] findUniqueCharacters(String name) {
        int length = findLength(name); // Calling the length function and storing the lenght calculated in variable
        char[] temp = new char[length]; // Creating a new char array with length calculated using length function
        int UNIQUE_COUNT = 0;

        // Loop for finding the unique characters in a string
        for(int i=0; i<length; i++) {
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
}
