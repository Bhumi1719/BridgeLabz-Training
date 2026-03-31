import java.util.Scanner;

public class PowerOfTwo {
    
    public static boolean isPowerOfTwo(int number) {
        if(number <= 0) return false;
        
        long num = (long) number;
        return (num & (num - 1)) == 0;      
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        boolean result = isPowerOfTwo(number);
        if(result) {
            System.out.println(number + " is a power of two.");
        } else {
            System.out.println(number + " is not a power of two.");
        }
    }
}