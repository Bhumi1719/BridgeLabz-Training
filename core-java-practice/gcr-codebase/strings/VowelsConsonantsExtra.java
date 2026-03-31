import java.util.*;

public class VowelsConsonantsExtra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        int[] vowelAndConsoCount = vowelAndConsonantCount(str); // Calling count function of vowels and consonants and storing it in array

        System.out.println("Number of Vowels is " + vowelAndConsoCount[0]);
        System.out.println("Number of Consonants is " + vowelAndConsoCount[1]);
    }

    // Method to check character type of the letters in string
    public static String characterCheck(char character) {

        // Converting uppercase to lowercase using ASCII values
        if(character >= 'A' && character <= 'Z') { // If in uppercase then add 32 and convert to lowercase
            character = (char) (character + 32);
        }

        // Checking if letter is an alphabet
        if(character >= 'a' && character <= 'z') {
            if(character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') { // If any vowel occurs then return vowel
                return "Vowel";
            } else { // If any consonant occurs return consonant
                return "Consonant";
            }
        }
        return "Not an Alphabet"; // If not an alphabet then return not a letter
    }

    // Method to find vowels and consonants count in string
    public static int[] vowelAndConsonantCount(String str) {
        // Counter for calculating vowel count
        int VOWELS = 0;
         
        // Counter for calculating consonant count
        int CONSONANTS = 0;

        // Counter for keeping track of the length of string
        int INDEX = 0;

        // Running an infinite loop with try catch block to stop when encountered with an exception 
        while(true) {
            try {
                char letter = str.charAt(INDEX);
                String ans = characterCheck(letter); // Calling the character checking method

                if(ans.equals("Vowel")) {
                    VOWELS ++; // If vowel then vowel counter increases
                } else if(ans.equals("Consonant")) {
                    CONSONANTS ++; // If consonant then consonant counter increases
                }

                INDEX ++; // Increamenting counter for each iteration to keep track of string length
            } catch (StringIndexOutOfBoundsException e) { // When index exceeds the string length then exception is thrown and loop terminates
                break;
            }
        }

        return new int[]{VOWELS, CONSONANTS}; // Returning a new array with count of vowels and consonants
    }
}
