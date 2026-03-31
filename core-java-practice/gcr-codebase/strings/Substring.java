import java.util.*;

public class Substring {

    // Method to create substring using charAt()
    public static String subStringCreation(String name, int start, int end) {
        String subString = "";
        for(int i=start; i<end; i++) {
            subString += name.charAt(i);
        }
        return subString;
    }

    // Method to compare two strings using charAt()
    public static boolean areEqual(String name1, String name2) {
        if(name1.length() != name2.length()) // Comparing the length of the two strings
            return false;

        for(int i=0; i<name1.length(); i++) {
            if(name1.charAt(i) != name2.charAt(i)) // Comparing the letters of the string
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String name = sc.next();

        System.out.print("Enter the starting index: ");
        int start = sc.nextInt();

        System.out.print("Enter the ending index: ");
        int end = sc.nextInt();

        String subStringCharAt = subStringCreation(name, start, end); // Substring using the method charAt

        String subStringBuiltIn = name.substring(start, end); // Substring using the ib-built method

        System.out.println("Substring using charAt(): " + subStringCharAt);
        System.out.println("Substring using built-in substring(): " + subStringBuiltIn);
       
        if(subStringCharAt.equals(subStringBuiltIn)) { // Comparing the result
            System.out.println("Result is same for both");
        } else {
            System.out.println("Result is not same");
        }
    }
}
