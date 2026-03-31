import java.util.*;

public class CensorBadWords {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String input = sc.nextLine();
        
        // List of bad words
        String[] badWords = {"damn", "stupid", "shit"};
        
        for(String word : badWords) {
            input = input.replaceAll("\\b" + word + "\\b", "****");
        }
        
        System.out.println("The required string is: " + input);
    }
}
