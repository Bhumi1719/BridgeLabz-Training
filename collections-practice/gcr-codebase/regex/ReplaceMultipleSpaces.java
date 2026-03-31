import java.util.*;

public class ReplaceMultipleSpaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String input = sc.nextLine();
        
        String output = input.replaceAll("\\s+", " ");
        
        System.out.println("The required string is: " + output);
    }
}
