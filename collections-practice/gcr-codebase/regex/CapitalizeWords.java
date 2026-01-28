import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class CapitalizeWords {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String text = sc.nextLine();

        String regex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("All the words starting with capital letters are:");
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
