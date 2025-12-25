import java.util.*;

public class AnagramExtra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String name1 = sc.nextLine();

        System.out.print("Enter the second string ");
        String name2 = sc.nextLine();

        boolean anagram = isAnagram(name1, name2);

        if(anagram) {
            System.out.println("The given strings are ANAGRAMS.");
        } else {
            System.out.println("The given strings are NOT Anagrams");
        }
    }

    // Method for checking if two strings are anagrams or not
    public static boolean isAnagram(String name1, String name2) {
        if(name1.length() != name2.length()) {
            return false;
        }

        // Creating frequency arrays for ASCII characters
        int[] frequency1 = new int[256];
        int[] frequency2 = new int[256];

        // Counting frequency of characters in both strings
        for(int i=0; i<name1.length(); i++) {
            frequency1[name1.charAt(i)] ++; // For string 1
            frequency2[name2.charAt(i)] ++; // For string 2
        }

        // Comparing frequencies of both the frequency arrays
        for(int i=0; i<256; i++) {
            if(frequency1[i] != frequency2[i]) {
                return false;
            }
        }
        return true;
    }
}
