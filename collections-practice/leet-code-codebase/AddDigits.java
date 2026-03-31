import java.util.*;

public class AddDigits {
    public static int addDigits(int num) {
        if(num<=9) {
            return num;
        }

        return 1+(num-1)%9;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        int result = addDigits(number);
        System.out.print("Sum of all digits is until one digit is left is: " + result);
    }
}
