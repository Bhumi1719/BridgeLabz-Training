import java.util.*;

class LeapYearMethods {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the month: ");
        int month = sc.nextInt();

        System.out.print("Enter the year: ");
        int year = sc.nextInt();

        String monthName = displayMonthName(month); // Calling the method to display month
        int days = dispalyNumberOfDays(month, year); // Calling the method to display number of days
        int firstDay = displayFirstDay(month, year); // Calling the method to display first day of the month

        System.out.println("\n" + monthName + " " + year);
        System.out.println("\nSun Mon Tue Wed Thu Fri Sat");

        // Loop for proper identation
        for(int i=0; i<firstDay; i++) {
            System.out.print("    ");
        }

        // Loop to display the calender
        for(int i=1; i<=days; i++) {
            System.out.printf("%3d ", i);
            if((i + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
    }

    // Method to check for a Leap Year
    public static boolean isLeapYear(int year) {
        if((year >= 1582) && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) { // Condition for a leap year
            return true;
        }

        return false; // If not leap year then return false
    }

    // Method to display the month name
    public static String displayMonthName(int month) {
        // Storing the names of months in a string
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return months[month - 1]; // Returning the month 
    }

    // Method to display number of days in a month
    public static int dispalyNumberOfDays(int month, int year) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // Storing the days in an array

        // Condition for a leap year
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }

        return days[month - 1]; // Retruning number of days
    }

    // Method to display first day of the month taking 0 as Sunday
    public static int displayFirstDay(int month, int year) {
        int DAY = 1;  
        int MONTH = month;
        int YEAR = year;

        if(MONTH < 3) {
            MONTH += 12;
            YEAR --;
        }

        int k = YEAR % 100;
        int j = YEAR / 100;

        int h = (DAY + (13 * (MONTH + 1)) / 5 + k + (k / 4) + (j / 4) + (5 * j)) % 7; // Formula to calculate the first day of the month
        return (h + 6) % 7; // Convert to Sunday = 0
    }
}
