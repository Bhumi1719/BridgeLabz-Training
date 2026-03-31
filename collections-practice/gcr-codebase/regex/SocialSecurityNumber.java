import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SocialSecurityNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Security Number: ");
        String number = sc.nextLine();

        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);

        if(matcher.find()) {
            System.out.println("\"" + matcher.group() + "\" is valid");
        } else {
            System.out.println("SSN is invalid");
        }
    }
}
