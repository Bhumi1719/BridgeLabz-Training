import java.util.*;

public class DivideTwoIntegers {
    
    public static int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;  // for handling overflow case
        } else {
            int quotient = dividend / divisor;
            return quotient;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter dividend: ");
        int dividend = sc.nextInt();

        System.out.print("Enter divisor: ");
        int divisor = sc.nextInt();

        int result = divide(dividend, divisor);
        System.out.println("Quotient is " + result);
    }
}
