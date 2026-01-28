import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExtractDates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String text = sc.nextLine();

        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Extracted dates are: ");
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
