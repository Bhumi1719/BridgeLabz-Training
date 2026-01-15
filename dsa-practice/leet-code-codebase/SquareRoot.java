import java.util.Scanner;

public class SquareRoot {
    
    public static int mySqrt(int number) {
        int START = 0 ;
        int END = number ;
        int RESULT = 0 ;
        
        while(START <= END){
            int mid = START + (END - START) / 2 ;
            if((long)mid * mid == (long)number){
                RESULT = mid ;
                break ;
            }else if ((long)mid * mid < (long)number){
                RESULT = mid ;
                START = mid + 1;
            }else{
                END = mid - 1 ; 
            }
        }
        return RESULT ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int number = sc.nextInt();

        int result = mySqrt(number);
        System.out.println("The square root of " + number + " is: " + result);
    }
}
