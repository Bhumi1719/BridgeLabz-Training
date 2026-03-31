import java.util.*;

public class YoungestTallestAmongThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Storing the names of three friends in the array to display their names using the index
        String[] names = {"Amar", "Akbar", "Anthony"}; 

        // Creating an integer array to store the age of the three friends
        int[] ages = new int[3];

        // Creating a double array to store the heights of the three friends
        double[] heights = new double[3];

        // Taking user input of age and height of the three friends
        for(int i=0; i<3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = sc.nextInt();

            System.out.print("Enter height of " + names[i] + " in cm: ");
            heights[i] = sc.nextDouble();
        }

        int youngest = findYoungestAmongThree(ages); // Calling the method to find the youngest
        int tallest = findTallestAmongThree(heights); // Calling the method to find the tallest

        System.out.println("\nYoungest friend among the three is: " + names[youngest]);
        System.out.println("Tallest friend among the three is: " + names[tallest]);
    }

    // Method for finding the youngest friend among the three
    public static int findYoungestAmongThree(int[] ages) {

        // Counter variable initialised to 0 to store the index of youngest
        int YOUNGEST = 0; 

        for(int i=1; i<ages.length; i++) { // Checking the youngest among the three
            if(ages[i] < ages[YOUNGEST]) {
                YOUNGEST = i;
            }
        }
        return YOUNGEST;
    }

    // Method for finding the tallest friend among the three
    public static int findTallestAmongThree(double[] heights) {

        // Counter variable inintialized to 0 to store the index of the tallest 
        int TALLEST = 0;

        for(int i=1; i<heights.length; i++) {
            if(heights[i] > heights[TALLEST]) { // Checking the tallest among the three
                TALLEST = i;
            }
        }
        return TALLEST;
    }
}
