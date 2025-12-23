import java.util.*;

public class Frequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String name = sc.nextLine();

        String[][] frequency = findFrequency(name); // Calling the function to find frequency and storing it in 2D array

        System.out.println("Character\tFrequency");
        for(int i=0; i<frequency.length; i++) {
            System.out.println(frequency[i][0] + "\t\t" + frequency[i][1]);
        }
    }

    // Method to find frequency of characters using charAt()
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

        // Creating a 2D array 
        String[][] result = new String[UNIQUE_COUNT][2]; // 2 for character and frequency
        int INDEX = 0; // Counter for tracking the string length

        // Loop for storing characters and their frequencies in the array
        for(int i=0; i<name.length(); i++) {
            char character = name.charAt(i);
            if(frequency[character] > 0) {
                result[INDEX][0] = String.valueOf(character); // Storing the character
                result[INDEX][1] = String.valueOf(frequency[character]); // Storing the frequency
                frequency[character] = 0; // Setting the frequency of character 0 again for avoiding the duplicate values
                INDEX ++; // Increamenting the index for tracking the string length
            }
        }
        return result;
    }
}
