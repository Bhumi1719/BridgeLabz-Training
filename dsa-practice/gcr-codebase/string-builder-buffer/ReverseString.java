import java.util.*;

public class ReverseString {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to reverse: ");
        String input = sc.nextLine();

        StringBuilder sb = new StringBuilder(input);

        String reversed = sb.reverse().toString();
        System.out.println("Reversed string is: " + reversed);

    }
}
