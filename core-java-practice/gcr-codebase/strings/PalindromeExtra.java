import java.util.*;

public class PalindromeExtra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String name = sc.nextLine();

        boolean isPalindrome = palindromeUsingIteration(name); // Calling the method

        if(isPalindrome) {
            System.out.println("The given string is a palindrome");
        } else {
            System.out.println("The given string is not a palindrome");
        }
    }

    // Method for verifying palindrome using Iterative Method
    public static boolean palindromeUsingIteration(String name) {
        int START = 0; // COunter for keeping track of start index of string
        int END = name.length() - 1; // Counter for keeping track of end index in string

        while(START < END) {
            if(name.charAt(START) != name.charAt(END)) { // Checking one character from starting with one character from end
                return false;
            }
            START ++;
            END --;
        }
        return true;
    }
}
