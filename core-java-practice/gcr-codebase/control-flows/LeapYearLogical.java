import java.util.*;

public class LeapYearLogical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the year ");
        int year = sc.nextInt();
        
        if(year >= 1582){
            // Checking if the year is a leap year using logical operators
            if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                System.out.println(year + " is a leap year");
            } else {
                System.out.println(year + " is not a leap year");
            }
        } else {
            System.out.println("Year should be 1582 or greater");
        }
    }
}