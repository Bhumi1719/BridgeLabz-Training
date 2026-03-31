import java.util.*;

public class ToUpperCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String name = sc.nextLine();

        // Convert using charAt method
        String upperNoMethod = toUpper(name);

        // Convert using built-in method
        String upperMethod = name.toUpperCase();

        // Compare the results of both the comparisons
        boolean isEqual = compareStrings(upperNoMethod, upperMethod);

        System.out.println("Uppercase using charAt(): " + upperNoMethod); // Without using in-built method
        System.out.println("Uppercase using toUpperCase(): " + upperMethod); // Using in-built method
        System.out.println("Both results are equal: " + isEqual); // Comparing the results
    }

    // Method for converting text to uppercase using charAt() and ASCII logic
    public static String toUpper(String name) {
        String result = "";
        for(int i=0; i<name.length(); i++) {
            char ch = name.charAt(i);
            if(ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32); // Convert to uppercase
            }
            result += ch;
        }
        return result;
    }

    // Method for comparing two strings using charAt()
    public static boolean compareStrings(String name1, String name2) {
        if(name1.length() != name2.length()) { // Comparing length of two strings
            return false;
        }
        for(int i=0; i<name1.length(); i++) {
            if(name1.charAt(i) != name2.charAt(i)) { // Comparing the letters of two strings
                return false;
            }
        }
        return true;
    }
}
