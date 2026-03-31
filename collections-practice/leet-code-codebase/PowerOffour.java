import java.util.Scanner;

public class PowerOffour {
    
    public static boolean isPowerOfFour(int n) {
        if(n <= 0) return false;

        if(n == 1) return true;

        return(n % 4 == 0 && isPowerOfFour(n/4));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if(isPowerOfFour(number)) {
            System.out.println(number + " is a power of four");
        } else {
            System.out.println(number + " is not a power of four");
        }
    }
}
