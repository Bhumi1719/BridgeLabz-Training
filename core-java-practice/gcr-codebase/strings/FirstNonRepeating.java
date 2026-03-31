import java.util.*;

public class FirstNonRepeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String name = sc.nextLine();

        char nonRepeat = displayFirstNonRepeating(name); // Calling the function for finding the first non-repeating character and storing it in char variable 

        // Conditionals for checking if there is any non-repeating char founded by the function or not
        if(nonRepeat != '\0') {
            System.out.println("First non-repeating character is " + nonRepeat);
        } else {
            System.out.println("No non-repeating character is there in the string");
        }
    }

    // Method to find first non-repeating character using charAt()
    public static char displayFirstNonRepeating(String name) {
        int[] frequency = new int[256]; // Creating an array ASCII characters

        // Loop for counting the frequency of each character in the string
        for(int i=0; i<name.length(); i++) {
            char character = name.charAt(i);
            frequency[character] ++; // Increasing the frequency of the element that occured
        }

        // Loop for finding the first character with frequency 1
        for(int i=0; i<name.length(); i++) {
            char ch = name.charAt(i);
            if(frequency[ch] == 1) { // Conditional for checking the frequency
                return ch; // If there is any element with frequency 1 then return the character
            }
        }

        return '\0'; // If there is no non-repeating character then return this
    }
}
