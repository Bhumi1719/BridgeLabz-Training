import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        for(int i=0; i<input.length(); i++) {
            char ch = input.charAt(i);
            if(!set.contains(ch)) {
                sb.append(ch);
                set.add(ch);
            }
        }

        String result = sb.toString();
        System.out.println("String without duplicates is: " + result);
    }
}
