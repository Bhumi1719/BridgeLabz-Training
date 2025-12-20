import java.util.*;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        int TEMP = number;
        int COUNT = 0;

        // Loop for finding count of the digits in number
        while (TEMP != 0) {
            COUNT ++;
            TEMP /= 10;
        }

        // Declaring array to store digit of number
        int[] digits = new int[COUNT];

        // Storing digits in array
        TEMP = number;
        for (int i=0; i<COUNT; i++) {
            digits[i] = TEMP % 10;
            TEMP /= 10;
        }

        // Loop to display reversed number
        System.out.print("Reversed number is ");
        for (int i=0; i<COUNT; i++) {
            System.out.print(digits[i]);
        }
    }
}
