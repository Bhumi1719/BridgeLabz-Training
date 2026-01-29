import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Currency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String input = sc.nextLine();

        String regex = "(?:[\\$₹€£]\\d+(?:\\.\\d{1,2})?)|(?:\\b\\d+(?:\\.\\d{1,2})?\\b)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        boolean found = false;
        while(matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }

        if(!found) {
            System.out.println("No currency value found");
        }
    }
}
