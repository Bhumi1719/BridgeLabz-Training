import java.util.*;

public class FindTheDifference {
    public static char findTheDifference(String s, String t) {
        char c = 0;
        for(char char1 : s.toCharArray()) {
            c ^= char1;
        }

        for(char char2 : t.toCharArray()) {
            c ^= char2;
        }

        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the fisrt string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter the second string: ");
        String str2 = sc.nextLine();

        char difference = findTheDifference(str1, str2);
        System.out.print("The difference between the two strings is: " + difference);
    }
}
