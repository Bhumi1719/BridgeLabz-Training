import java.util.*;

public class CompareSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number ");
        int number = sc.nextInt();

        if(number >= 1){
            // Computing sum of natural numbers using formula
            int sumFormula = number * (number + 1) / 2;

            int SUM_WHILE = 0;

            // Computing the sum using while loop
            while(number >= 1) {
                SUM_WHILE += number; // Adding the value of number to SUM_WHILE until number reaches 1
                number--; // Decreasing the value of number by 1 for each iteration
            }

            // Comparing both results of sum
            if(sumFormula == SUM_WHILE) {
                System.out.println("The sum of " + number + " natural numbers using both methods are equal ,i.e., " + sumFormula);
            } else {
                System.out.println("The sums are not equal");
            }
        } else{
            System.out.println("The number " + number + " is not a natural number");
        }
    }
}