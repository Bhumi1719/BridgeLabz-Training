import java.util.*;

public class PositiveNegativeArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Declaring array of size 5
        int[] number = new int[5];

        System.out.print("Enter the numbers: ");
        // Taking input from user
        for(int i=0; i<number.length; i++){
            number[i] = sc.nextInt();
        }

        // Loop for checking whether the number entered are positive, negative or zero
        for(int i=0; i<number.length; i++){
            // If condition for checking positive
            if(number[i] > 0){
                if(number[i] % 2 == 0){ // This If condition is for even
                    System.out.println("The number is postive and even");
                } else{ // This else condition for odd
                    System.out.println("The number is positive and odd");
                }
            } else if(number[i] < 0){ // This else if block for negative number
                System.out.println("The number is negative");
            } else{ // This else block is for zero
                System.out.println("The number is zero");
            }
        }
        
        // Condition to check if the first and the last element of the array are same or lesser or greater
        if(number[0] == number[number.length-1]){
            System.out.println("The first and the last element of array are same");
        } else if(number[0] > number[number.length-1]){
            System.out.println("The first element is greater than the last element in array");
        } else{
            System.out.println("The last element is greater than the first element in array");
        }
    }
}