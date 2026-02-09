import java.util.Scanner;

public class GoatLatin {
    public static String toGoatLatin(String sentence) {
        String[] strs = sentence.split(" ");

        StringBuilder a = new StringBuilder("a");

        StringBuilder res = new StringBuilder();

        for(String str : strs) {

            StringBuilder sb = new StringBuilder();

            if(isVowel(str.charAt(0))) {
                sb.append(str);     
                sb.append("ma");
            }
           
            else {
                sb.append(str.substring(1));   // remove first character
                sb.append(str.charAt(0));      // move first character to end
                sb.append("ma");
            }

            sb.append(a);
            res.append(" ").append(sb);
            a.append("a");
        }

        return res.toString().trim();
    }

    static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the sentence:");
        String sentence = sc.nextLine();

        System.out.println("\nThe sentence in Goat Latin form is:\n" + toGoatLatin(sentence));
    }
}