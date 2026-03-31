import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String name = sc.nextLine();

        // Creating a string builder to store the resulted characters
        StringBuilder nonDuplicates = new StringBuilder();

        // Creating hashset to store the letters of the string
        HashSet<Character> set = new HashSet<>();

        // Converting the string to character array
        char[] character = name.toCharArray();

        // Finding the duplicates and removing them
        for(char ch : character) {
            if(!set.contains(ch)) {
                set.add(ch);
                nonDuplicates.append(ch);
            }
        }

        System.out.println("String with non-duplicate elements is: " + nonDuplicates.toString());
    }
}