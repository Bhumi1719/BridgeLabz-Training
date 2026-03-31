import java.util.*;

public class StringReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String name = sc.nextLine();

        // Converting the string to array
        char[] chArray = name.toCharArray();

        // Counter to keep track of the string length from starting
        int START = 0;

        // Counter to keep track of the string length from end
        int END = name.length() - 1;

        // Loop to reverse the letters in a string
        while(START < END) {
            char character = chArray[START];
            chArray[START] = chArray[END];
            chArray[END] = character;

            START ++; // Increamenting the length from the start
            END --; // Decreamenting the length from the end
        }

        String reversed = new String(chArray); // Converting the array into string again
        System.out.println("The reversed string is: " + reversed);
    }
}