import java.util.*;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String name = sc.nextLine();

        // Creating an empty string to store the result
        String toggle = "";

        // Loop to convert the leeters of string
        for(int i=0; i<name.length(); i++) {
            char character = name.charAt(i);
            if(character >= 'a' && character <= 'z') {
                toggle += (char) (character - 32);
            } else if (character >= 'A' && character <= 'Z') {
                toggle += (char) (character + 32);
            } else {
                toggle += character;
            }
        }

        System.out.println("The resultant string is: " + toggle);
    }
}