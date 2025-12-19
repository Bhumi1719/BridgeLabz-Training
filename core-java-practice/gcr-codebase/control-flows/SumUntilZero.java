import java.util.*;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double TOTAL = 0.0;
        double number = sc.nextDouble();

        // Using while loop to sum until the user enters 0
        while(number != 0) {
            total += number; // If the value entered by user is not 0 then the value will be added to total
            number = sc.nextDouble(); // Taking next input from cuser until it enters 0
        }

        System.out.println("The total value is " + total);
    }
}