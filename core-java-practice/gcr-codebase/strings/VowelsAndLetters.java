import java.util.*;

public class VowelsAndLetters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        String[][] ans = characterType(str); // Calling the method to check the character type and storing it in variable
        
        // Printing the array
        System.out.println("Character\tType");
        for(int i=0; i<ans.length; i++) {
            System.out.println(ans[i][0] + "\t\t" + ans[i][1]);
        }
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
        return "Not a Letter"; // If not an alphabet then return not a letter
    }

    // Method to find vowels and consonants count in string
    public static String[][] characterType(String name) {        
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

        String[][] type = new String[COUNT][2]; // Declaring a 2D array to store the type of character
 
        // Counter for keeping track of length of string
        int INDEX = 0;

        // Infinite loop with try catch block
        while(true) {
            try {
                char character = name.charAt(INDEX);
                type[INDEX][0] = String.valueOf(character);
                type[INDEX][1] = characterCheck(character);
                INDEX ++;
            } catch (StringIndexOutOfBoundsException e) { // Whenever index value exceeds string length an exception is thrown and loop is terminated
                break;
            }
        }
        return type; // Returning a 2D string 
    }
}
