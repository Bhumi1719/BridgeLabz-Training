import java.util.*;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = takeInput(sc); // Calling the method to take the user input
        boolean result = isPalindrome(name); // Calling the method to check for palindrome and storing it in variable
        printResult(name, result); // Calling the method to print the result
    }

    // Method for taking string user input
    public static String takeInput(Scanner sc) {
        System.out.print("Enter a string: ");
        return sc.nextLine();
    }

    // Method for checking whether the string is a palindrome or not
    public static boolean isPalindrome(String name) {
        int START = 0; // Counter variable to keep track of the lenght of the string from the starting
        int END = name.length() - 1; // Counter variable to keep track of the length of the string from the ending
 
        // Loop for checking the string to be palindrome or not
        while(START < END) {
            if(name.charAt(START) != name.charAt(END)) { // If the character from start is not equal to character from end then return false
                return false;
            }
            START ++; // Increamenting the counter from start
            END --; // Decreamenting the counter form end
        }

        return true; // Else return true
    }

    // Method for displaying the result
    public static void printResult(String name, boolean result) {
        if(result) {
            System.out.println("\"" + name + "\" is a Palindrome");
        } else {
            System.out.println("\"" + name + "\" is not a Palindrome");
        }
    }
}
