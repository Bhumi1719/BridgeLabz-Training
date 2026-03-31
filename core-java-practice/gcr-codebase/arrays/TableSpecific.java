import java.util.*;

public class TableSpecific {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        // Declaring the array for storing the result
        int[] table = new int[10];

        if(number >= 6 && number <= 8) {
            // Looping to store the result the result of multiplication in array
            for(int i=1; i<=10; i++){
                table[i-1] = number * i;
            }

            System.out.println("Multiplication table of " + number + " is ");
            // For loop for displaying the result
            for(int i=0; i<table.length; i++){
                System.out.println(number + " X " + (i+1) + " = " + table[i]);
            }
        } else{
            System.out.println("Enter a valid number");
        }
    
    }
}