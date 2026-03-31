import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinksFromWebPage {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String text = sc.nextLine();

        String regex = "https?://[^\\s,]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Extracted links are: ");
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
