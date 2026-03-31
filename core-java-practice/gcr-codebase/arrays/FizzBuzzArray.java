import java.util.*;

public class FizzBuzzArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); 

        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        // Declaring a string array to store the result
        String[] fizzBuzz = new String[number];

        // Counter for tracking the index of the array 
        int counter = 0;

        // Conditionals to check whether it is a positive number or not
        if(number > 0){
            for (int i = 1; i <= number; i++) { // Loop for checking each element upt the number
                if (i % 3 == 0 && i % 5 == 0) { // For multiples of both 3 and 5
                    fizzBuzz[counter] = "FizzBuzz";
                    counter++;
                } else if (i % 3 == 0) { // For multiples of only 3
                    fizzBuzz[counter] = "Fizz";
                    counter++;
                } else if (i % 5 == 0) { // For multiples of only 5
                    fizzBuzz[counter] = "Buzz";
                    counter++;
                } else { // For other numbers
                    fizzBuzz[counter] = String.valueOf(i);
                    counter++;
                }
            }
        } else{
            System.out.println("Enter a positive number"); // This will execute when positive number is not entered
        }

        System.out.println("The elements of fizzBuzz array are: ");
        // For loop for printing the string array
        for(int i=0; i<fizzBuzz.length; i++){
            System.out.print(fizzBuzz[i] + " ");
        }
    } 
}