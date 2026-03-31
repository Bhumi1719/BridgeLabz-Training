import java.util.*;

public class CompareLexi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String name1 = sc.nextLine();

        System.out.print("Enter the second string: ");
        String name2 = sc.nextLine();

        // Storing the length of the first string
        int length1 = name1.length();

        // Storing the length of the second string
        int length2 = name2.length();

        // finding the minimum length of the two lengths
        int MIN_LENGTH = Math.min(length1, length2);

        int RESULT = 0;

        // Loop to compare the characters of the two string 
        for(int i=0; i<MIN_LENGTH; i++) {
            char character1 = name1.charAt(i); // Checking each character of string1
            char character2 = name2.charAt(i); // Checking each character of string2

            if(character1 != character2) {
                RESULT =  character1 - character2; // positive if character1>character2, negative if character1<character2
                break;
            }
        }

        if(RESULT == 0) { // If there is no difference in characters then compare using lengths of both strings
            RESULT = length1 - length2;
        }

        // Printing the result
        if(RESULT < 0) {
            System.out.println("\"" + name1 + "\" comes before \"" + name2 + "\" in lexicographical order");
        } else if(RESULT > 0) {
            System.out.println("\"" + name1 + "\" comes after \"" + name2 + "\" in lexicographical order");
        } else {
            System.out.println("Both strings are equal");
        }

    }
}