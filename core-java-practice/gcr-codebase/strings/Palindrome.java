import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string ");
        String name = sc.nextLine();

        boolean iterative = palindromeUsingIteration(name);
        boolean recursive = palindromeUsingRecursion(name, 0, name.length() - 1);
        boolean array = palindromeUsingArray(name);

        System.out.println("Is tha string a palindrome(Using Iteration): " + iterative);
        System.out.println("Is tha string a palindrome(Using Recursion): " + recursive);
        System.out.println("Is tha string a palindrome(Using Array): " + array);
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

    // Method for verifying palindrome using Recursion
    public static boolean palindromeUsingRecursion(String name, int start, int end) {
        if(start >= end) {
            return true; // base condition
        }
        if(name.charAt(start) != name.charAt(end)) {
            return false;
        }
        return palindromeUsingRecursion(name, start + 1, end - 1);
    }

    // Method for reversing a string using charAt()
    public static char[] stringRev(String name) {
        char[] reverse = new char[name.length()]; // Creating an array of size upto the length of the string

        for(int i=0; i<name.length(); i++) {
            reverse[i] = name.charAt(name.length() - 1 - i); // Storing in character array from end
        }
        return reverse;
    }

    // Method of verifying the palindrome using the Array
    public static boolean palindromeUsingArray(String name) {
        char[] original = name.toCharArray(); // Converting the string to character array
        char[] reverse = stringRev(name); // Reversing the string and storing it in reverse array

        for(int i=0; i<original.length; i++) {
            if (original[i] != reverse[i]) { // Comparing both the arrays above
                return false;
            }
        }
        return true;
    }
}
