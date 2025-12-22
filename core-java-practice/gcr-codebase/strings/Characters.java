import java.util.*;

public class Characters {

    // Method to return characters of a string without using toCharArray()
    public static char[] printCharacters(String name) {
        char[] character = new char[name.length()];
        for(int i=0; i<name.length(); i++) {
            character[i] = name.charAt(i);
        }
        return character;
    }

    // Method to compare the two arrays
    public static boolean compareArrays(char[] ch1, char[] ch2) {
        if(ch1.length != ch2.length) { // Comparing the length of two arrays
            return false;
        }

        for(int i=0; i<ch1.length; i++) {
            if(ch1[i] != ch2[i]) { // Comparing the letters of the arrays
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String name = sc.next();

        // Array without using in-built method
        char[] arrayNoMethod = printCharacters(name);

        // Array using in-built method
        char[] arraytoChar = name.toCharArray();

        // Compare both the arrays
        boolean isEqual = compareArrays(arrayNoMethod, arraytoChar);

        System.out.println("Characters from user-defined method:");
        for (char c : arraytoChar) {
            System.out.print(c + " ");
        }

        System.out.println("\nCharacters from toCharArray() method:");
        for (char c : arrayNoMethod) {
            System.out.print(c + " ");
        }

        System.out.println("\nBoth character arrays are equal: " + isEqual);
    }
}
