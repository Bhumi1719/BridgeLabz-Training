import java.util.*;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        int temp = number;
        int count = 0;

        // Loop for finding count of the digits in number
        while (temp != 0) {
            count ++;
            temp /= 10;
        }

        // Declaring array to store digit of number
        int[] digits = new int[count];

        // Storing digits in array
        temp = number;
        for (int i=0; i<count; i++) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        // Loop to display reversed number
        System.out.print("Reversed number is ");
        for (int i=0; i<count; i++) {
            System.out.print(digits[i]);
        }
    }
}
