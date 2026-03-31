import java.util.*;

public class CompareArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter the second string: ");
        String str2 = sc.nextLine();

        boolean resultWithEquals = str1.equals(str2); // Using in-built method for comparing strings
        boolean resultWithCharAt = areEqual(str1, str2); // USing charAt for comparing strings

        System.out.println("Are both strings equal(Using charAt()) : " + resultWithCharAt);
        System.out.println("Are both strings equal(Using equls()) : " + resultWithEquals);

        if(resultWithCharAt == resultWithEquals){ // Comparing the two results
            System.out.println("Result with both the methods is same");
        } else{
            System.out.println("Result is not same");
        }
    }

    public static boolean areEqual(String name1, String name2) {
        if(name1.length() != name2.length()) // Comparing the length of the two strings
            return false;

        for(int i=0; i<name1.length(); i++) {
            if(name1.charAt(i) != name2.charAt(i)) // Comparing the letters of the string
                return false;
        }
        return true;
    }
}