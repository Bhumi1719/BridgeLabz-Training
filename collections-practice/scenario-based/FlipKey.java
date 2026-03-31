import java.util.*;

public class FlipKey {

    public static String CleanseAndInvert(String input) {

        // String validation
        if(input == null || input.length() < 6) {
            return "";
        }

        if(input.matches(".*\\s.*") || input.matches(".*\\d.*") || input.matches(".*[^a-zA-Z0-9\\\\s].*")) {
            return "";
        }

        // Converting the string to lowercase
        input = input.toLowerCase();

        // Creating a string builder to store only the odd ascii value characters
        StringBuilder newString = new StringBuilder();

        for(int i=0; i<input.length(); i++) {
            char character = input.charAt(i);
            int ascii = (int) character;

            // Checking for odd ascii value characters
            if(ascii % 2 != 0) {
                newString.append(character);
            }
        }

        // Reversing the new appended string
        newString.reverse();

        // Converting even index character to uppercase
        for(int i=0; i<newString.length(); i++) {
            if(i % 2 == 0) {
                newString.setCharAt(i, Character.toUpperCase(newString.charAt(i)));
            }
        }

        return newString.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String input = sc.nextLine();

        String key = CleanseAndInvert(input);

        if(key.equals("")) {
            System.out.println("Invalid Input");
        } else {
            System.out.print("The generated key is " + key);
        }
    }
}
