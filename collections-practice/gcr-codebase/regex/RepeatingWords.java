import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class RepeatingWords {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String text = sc.nextLine();

        String regex = "\\b(\\w+)\\b\\s+\\b\\1\\b";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;

        while(matcher.find()) {
            System.out.println(matcher.group(1));
            found = true;
        }

        if(!found) {
            System.out.println("No repeated words found");
        }
    }
}
