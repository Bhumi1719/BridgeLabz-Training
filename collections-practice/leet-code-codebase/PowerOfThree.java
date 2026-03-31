import java.util.Scanner;

public class PowerOfThree {
    
    public static boolean isPowerOfThree(int n) {
        if(n <= 0){
            return false;
        }
        if(n == 1){
            return true;
        }

        return(n % 3 == 0 && isPowerOfThree(n/3));
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if(isPowerOfThree(n)){
            System.out.println(n + " is a power of three.");
        } else {
            System.out.println(n + " is not a power of three.");
        }
    }
}
