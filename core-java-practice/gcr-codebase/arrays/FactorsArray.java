import java.util.*;

public class FactorsArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        // Variable to store the max size of array
        int maxFactor = 10;

        // Declaring an array to store the factors of the number
        int[] factors = new int[maxFactor];


        // Counter to keep track of index of the array
        int index = 0;

        if(number > 0){
            // For loop for finding the factors of the number
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {

                    // If array is full, increase its size
                    if (index == maxFactor) {
                        maxFactor = maxFactor * 2;
                        int[] temp = new int[maxFactor];

                        for (int j=0; j <factors.length; j++) { // If array gets full then copying the elements of factor array to new array of more size
                            temp[j] = factors[j];
                        }
                        factors = temp; // Assigning new array back to factor array
                    }

                    // Adding the factors of the number to the array
                    factors[index] = i;
                    index++; // Increamenting the index to add element to the next index of array
                }
            }

            // Loop for printing the array of factors
            System.out.println("Factors of " + number + " are: ");
            for (int i= 0; i <index; i++) {
                System.out.println(factors[i]);
            }

        } else{
            System.out.println("Enter a positive number");
        }
    }
}
