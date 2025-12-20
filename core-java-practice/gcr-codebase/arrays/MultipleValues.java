import java.util.*;

public class MultipleValues {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Declaring an array of size 10
        double[] number = new double[10];

        // To find the total of all the elements added to the array
        double TOTAL = 0.0;

        // Counter variable to keep track of index of array
        int INDEX = 0;
 
        // Infinite while loop to add multiple elements int he array
        while(true){
            System.out.print("Enter the number: ");
            int num = sc.nextInt();

            if(num <= 0 || num >= 10){
                break; // Edge case for the infinite loop to terminate
            } else{
                number[INDEX] = num;
                INDEX ++; // Increament to add the number on next index for next iteration
            }
        }

        // for loop to add the elements to the total variable
        for(int i=0; i<number.length; i++){
            TOTAL += number[i];
        }

        System.out.println("The total is: " + TOTAL);
    }
}