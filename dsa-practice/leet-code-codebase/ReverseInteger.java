import java.util.Scanner;

public class ReverseInteger {
    
    public static int reverse(int number) {
        long num = 0;
        while(number != 0){
            int n = number % 10;
            number = number / 10;
            num = (num * 10) + n;
        }

        if(num > Integer.MAX_VALUE || num < Integer.MIN_VALUE){
            return 0;
        }
        return (int)num;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer to reverse: ");
        int number = sc.nextInt();

        int reversedNumber = reverse(number);
        System.out.println("Reversed Integer is: " + reversedNumber);
    }
}
