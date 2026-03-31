import java.util.*;

public class PositiveNegativeOrZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        // Calling the function and printing it directly
        System.out.println(findNumberType(number));
    }

    public static int findNumberType(int number) {
        if(number > 0) { // For positive number
            return 1;
        } else if(number < 0) { // For negative number
            return -1;
        } else { // For zero
            return 0;
        }
    }
}