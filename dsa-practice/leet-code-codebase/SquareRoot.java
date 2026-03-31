import java.util.Scanner;

public class SquareRoot {
    
    public static int mySqrt(int number) {
        int start = 0 ;
        int end = number ;
        int result = 0 ;
        
        while(start <= end){
            int mid = start + (end - start) / 2 ;
            if((long)mid * mid == (long)number){
                result = mid ;
                break ;
            }else if ((long)mid * mid < (long)number){
                result = mid ;
                start = mid + 1;
            }else{
                end = mid - 1 ; 
            }
        }
        return result ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int number = sc.nextInt();

        int result = mySqrt(number);
        System.out.println("The square root of " + number + " is: " + result);
    }
}
