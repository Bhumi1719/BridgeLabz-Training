import java.util.Scanner;

public class AmarAkbar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Declaring and initializing array with names of the three friends
        String[] NAMES = {"Amar", "Akbar", "Anthony"};

        // Declaring the array for storing ages of the three friends
        int[] age = new int[3];

        // Declaring the array for storing heights of the three friends
        double[] height = new double[3];

        // Loop for taking user input for heights and ages of Amar, Akbar, Anthony
        for (int i=0; i<3; i++) {
            System.out.print("Enter the age of " + NAMES[i] + ": ");
            age[i] = sc.nextInt();

            System.out.print("Enter the height of " + NAMES[i] + ": ");
            height[i] = sc.nextDouble();
        }

        // Variable for checking status of yongest among three
        int YOUNGEST = 0;

        // Variable for checking status of yongest among three
        int TALLEST = 0;

        for (int i=1; i<3; i++) {
            if (age[i] < age[YOUNGEST]) { // For checking youngest
                YOUNGEST = i;
            }
            
            if (height[i] > height[TALLEST]) { // For checking tallest
                TALLEST = i;
            }
        }

        System.out.println("Youngest among the three is " + NAMES[YOUNGEST]);
        System.out.println("Tallest among the three is " + NAMES[TALLEST]);
    }
}
