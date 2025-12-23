import java.util.*;

public class FrequencyNested {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String name = sc.nextLine();

        String[] frequency = findFrequency(name);

        // Printing the result using for each loop
        System.out.println("Char : Freq");
        for (String str : frequency) {
            System.out.println(str);
        }
    }

    // Method for finding frequency of characters in string using nested loops
    public static String[] findFrequency(String name) {
        char[] chars = name.toCharArray(); // Converting the string to char array
        int[] frequency = new int[chars.length]; // Creating a frequency array with length upto the length of the character array 

        for(int i=0; i<chars.length; i++) { // Initialising frequency array with 1 for each character in the string
            frequency[i] = 1;
        }

        // Use of nested loops for finding the frequency
        for(int i=0; i<chars.length; i++) {
            if(chars[i] == '0') continue;

            for(int j=i + 1; j<chars.length; j++) {
                if(chars[i] == chars[j]) { // If duplicate elements are there then increase the frequency of that element by 1
                    frequency[i] ++;
                    chars[j] = '0'; // This is done to avoid the duplicates
                }
            }
        }

        int COUNT = 0;
        // Loop for counting the uniques characters in the string
        for(int i=0; i<chars.length; i++) {
            if(chars[i] != '0') {
                COUNT ++;
            }
        }

        String[] result = new String[COUNT]; // New array creation for storing the result

        int INDEX = 0; // Counter to keep track of the array index

        for(int i=0; i<chars.length; i++) {
            if(chars[i] != '0') {
                result[INDEX ++] = chars[i] + " : " + frequency[i];
            }
        }
        return result;
    }
}
