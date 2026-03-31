import java.util.*;

public class StringLength {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String st = sc.nextLine();

        // Calling the function to find length and storing it in variable
        int strLength = findLength(st);

        // Storing the length using built-in method in variable
        int inputLength = st.length();

        System.out.println("The length of the given string without using built-in method is: " + strLength); // For length without using built-in method
        System.out.println("The length of the given using built-in methos is: " + inputLength); // For length using built-in method
    }

    // Method to find the length of string accepting a parameter string
    public static int findLength(String name) {
        // Counter variable to keep track of the length of string
        int COUNT = 0;
        
        // Running an infinite loop to find the length and stoping it using a try catch block 
        while(true) {
            try { // For counting the length using counter variable
                name.charAt(COUNT);
                COUNT ++; // Counter is increamented for each iteration
            } catch(StringIndexOutOfBoundsException e) { // When the counter exceeds the string length it throws an error and breaks the loop
                break;
            }
        }

        return COUNT; // return an integer for the method
    }
}