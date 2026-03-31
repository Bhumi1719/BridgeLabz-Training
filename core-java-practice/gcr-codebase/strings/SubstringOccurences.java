import java.util.*;

public class SubstringOccurences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String name = sc.nextLine();

        System.out.print("Enter the substring: ");
        String subString = sc.nextLine();

        // Keeping a counter variable to count the occurences
        int COUNT = 0;

        // Keeping track of index of the length
        int INDEX = 0;

        // Loop for finding the occurences of substring
        while((INDEX = name.indexOf(subString, INDEX)) != -1) {
            COUNT ++;
            INDEX += subString.length();
        }

        System.out.println("The occurences of the suString in the given string is: " + COUNT);
    }
}