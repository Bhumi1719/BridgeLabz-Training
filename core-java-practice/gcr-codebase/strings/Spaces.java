import java.util.*;;

public class Spaces {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        int[] index = trimIndex(str); // Calling the function for trimming the string and storing the result in in an array

        String trimNoMethod = substringCreation(str, index[0], index[1]); // Calling the new string formation method after removing spaces and storing in string

        String trimByMethod = str.trim(); // Trimming by using in-built method

        boolean isEqual = areEqual(trimNoMethod, trimByMethod); // Calling the comaraing method and storing in boolean variable 

        System.out.println("Trimmed string without using inbuilt method: \"" + trimNoMethod + "\""); // Without in-built method
        System.out.println("Trimmed string using inbuilt method, trim(): \"" + trimByMethod + "\""); // With in-built method
        System.out.println("Both strings are equal ? " + isEqual); // Comapring strings
    }

    // Method to find start and end index without leading/trailing spaces
    public static int[] trimIndex(String name) {
        int START_INDEX = 0; // Counter to keep track of index from start
        int END_INDEX = name.length() - 1; // Counter  to keep track of index from end

        // Loop to trim leading spaces 
        while(START_INDEX <= END_INDEX && name.charAt(START_INDEX) == ' ') {
            START_INDEX ++; // Increament starting index for each iteration
        }

        // Loop to trim trailing spaces
        while(END_INDEX >= START_INDEX && name.charAt(END_INDEX) == ' ') {
            END_INDEX --; // Decreament ending index for each iteration
        }

        return new int[]{START_INDEX, END_INDEX}; // Returning a new array with count of starting and ending index 
    }

    // Method for creating substring from string using charAt()
    public static String substringCreation(String name, int start, int end) {
        String spaces = "";
        for(int i=start; i<=end; i++) {
            spaces += name.charAt(i); // Adding characters of string one by one
        }
        return spaces; // Returning string with trimmed string
    }

    // Method for comparing the strings using charAt()
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
