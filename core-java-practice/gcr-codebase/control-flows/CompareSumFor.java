import java.util.*;

public class CompareSumFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number ");
        int number = sc.nextInt();

        if(number >= 1){
            // Computing sum of natural numbers using formula
            int sumFormula = number * (number + 1) / 2;

            int SUM_WHILE = 0;

            // Computing the sum using for loop
            for (int i = number; i >= 1; i--) {
                SUM_WHILE += i; // Adding the value of i to SUM_WHILE until i reaches 1
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