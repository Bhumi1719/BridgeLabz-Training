import java.util.*;

public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the year: ");
        int year = sc.nextInt();

        // Checking if year is less than the given condition
        if(year < 1582) {
            System.out.println("Enter the year 1582 or greater");
            return;
        }

        // Calling the function directly inside the conditionals
        if(isLeapYear(year)) {
            System.out.println(year + " is a Leap Year");
        } else {
            System.out.println(year + " is not a Leap Year");
        }
    }

    // Method for checking the leap year
    public static boolean isLeapYear(int year) {
        boolean isBoolean = false; // Initializing boolean variable with false 
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){ // Condition for the leap year
            isBoolean = true;
            return isBoolean;
        }
        return isBoolean;
    }
}
