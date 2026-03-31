import java.util.*;

public class FrequentCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String name = sc.nextLine();

        // Creating int array to store frequency for the leetrs in the string
        int[] frequency = new int[256]; 

        // Loop to count the frequency of each character in the string
        for(int i=0; i<name.length(); i++) {
            frequency[name.charAt(i)] ++;
        }

        // Variable to store the character with maximum frequency
        char MOST_FREQUENT = name.charAt(0);

        // Variable to comapre the frequency with
        int MAX_COUNT = 0;

        // Loop to find the character with maximum frequency
        for(int i=0; i<name.length(); i++) {
            char character = name.charAt(i);

            if(frequency[character] > MAX_COUNT) {
                MAX_COUNT = frequency[character];
                MOST_FREQUENT = character;
            }
        }

        System.out.println("The character with the maximum occurance in the string is: " + MOST_FREQUENT);
    }
}