import java.util.*;

public class OddEvenArrays {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        // Declaring array for storing even numbers
        int[] even = new int[number/2];

        // Declaring array for storing odd numbers
        int[] odd = new int[number/2];

        // Conditional statement for checking if number number enterd is natural or not
        if(number > 0){
            int evenIndex = 0; // Counter for even number
            int oddIndex = 0; // Counter for odd number

            // For loop for adding even elements in even array and odd elements in odd array
            for(int i=1; i<=number; i++){
                if(i % 2 == 0){
                    even[evenIndex] = i; // If even element then add element to the even array at index 0 at starting
                    evenIndex ++; // Even index is increamented for increasing the index to store elements one after other
                } else{
                    odd[oddIndex] = i; // If odd element then add element to the odd array at index 0 at starting
                    oddIndex ++; // Odd index is increamented for increasing the index to store elements one after other
                }
            }

            System.out.print("Elements of Even array are: ");
            // For loop for printing the even array
            for(int i=0; i<even.length; i++){
                if(even[i] % 2 == 0){
                    even[evenIndex] = i; // If even element then add element to the even array at index 0 at starting
                    evenIndex ++; // Even index is increamented for increasing the index to store elements one after other
                } else{
                    odd[oddIndex] = i; // If odd element then add element to the odd array at index 0 at starting
                    oddIndex ++; // Odd index is increamented for increasing the index to store elements one after other
                }
            }

            System.out.print("Elements of Even array are: ");
            // For loop for printing the even array
            for(int i=0; i<even.length; i++){
                System.out.print(even[i] + " ");
            }

            System.out.println(); // For extra line
            
            System.out.print("Elements of Odd array are: ");
            // For loop for printing the odd array
            for(int i=0; i<odd.length; i++){
                System.out.print(odd[i] + " ");
            }
        } else{
            System.out.println("Error : Enter a natural number"); // If not a natural number the this else block will be executed
        }
    }
}