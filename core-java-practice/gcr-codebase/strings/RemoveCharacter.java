import java.util.*;

public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String name = sc.nextLine();

        System.out.print("Enter the character to be removed from string: ");
        char character = sc.next().charAt(0);

        // Creating a string builder to store the reamining from string except the character to be removed
        StringBuilder removeChar = new StringBuilder();

        // Removing the character from the string
        for(int i=0; i<name.length(); i++) {
            if(name.charAt(i) != character) {
                removeChar.append(name.charAt(i)); // Adding the remaining characters from the string
            }
        }

        System.out.println("The remaining string is: " + removeChar.toString());
    }
}