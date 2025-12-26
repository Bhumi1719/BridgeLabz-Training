import java.util.*;

public class AvgMaxMin {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        // Creating an object of the class to call it as we have not made the method static
        AvgMaxMin avg = new AvgMaxMin();

        int[] randomNumbers = avg.generateRandomNumbers(size); // Calling the method to generate numbers using the object 

        // Displayin gthe numbers generated
        System.out.println("\nGenerated 4-digit random numbers are: ");
        for(int number : randomNumbers) {
            System.out.print(number + " ");
        }

        double[] result = avg.findAverageMinMax(randomNumbers); // Calling the method to find the avg min and max using the object

        // Displaying the avg min and max of the numbers
        System.out.println("\n\nAverage is: " + result[0]);
        System.out.println("Minimum is: " + (int) result[1]);
        System.out.println("Maximum is: " + (int) result[2]);
    }

    // Method for generating an array of 4-digit random numbers
    public int[] generateRandomNumbers(int size) {
        // Creating an array for storing the numbers
        int[] numbers = new int[size];

        // Loop for generating the 4 digit random numbers
        for(int i=0; i<size; i++) {
            numbers[i] = (int) (Math.random() * 9000) + 1000; // (1000 to 9999)
        }

        return numbers; // Returning the array
    }

    // Method for finding the average, minimum and maximum of the numbers generated
    public double[] findAverageMinMax(int[] numbers) {
        // Variable for storing the minimum number
        int MINIMUM = numbers[0];

        // Variable for storing the maximum number
        int MAXIMUM = numbers[0];

        // Variable for storing the sum of the numbers to calculate the average
        int SUM = 0;

        // for-each loop for finding the sum, minimum and maximum of the numbers
        for(int number : numbers) {
            SUM += number;
            MINIMUM = Math.min(MINIMUM, number);
            MAXIMUM = Math.max(MAXIMUM, number);
        }

        double average = (double) SUM / numbers.length; // Finding the average of the numbers generated

        return new double[]{average, MINIMUM, MAXIMUM}; // Returning an array with all the three results
    }
}
