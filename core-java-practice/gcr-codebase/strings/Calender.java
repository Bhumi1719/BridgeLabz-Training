import java.util.*;

public class Calender {

    // Method for displaying the month of the year
    public static String displayMonth(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return months[month - 1];
    }

    // Method for checking the leap year
    public static boolean isLeapYear(int year) {
        boolean isLeap = false;
        if((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            isLeap = true;
        }
        return isLeap;
    }

    // Method for displaying the number of days in month
    public static int displayDaysInMonth(int month, int year) {
        int[] days = {
                31, 28, 31, 30,
                31, 30, 31, 31,
                30, 31, 30, 31
        };

        if(month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month - 1];
    }

    // Method to get first day of the month (0=Sunday)
    public static int displayDayOne(int month, int year) { // Formula
        int d = 1;
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;
        return d0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter the year: ");
        int year = sc.nextInt();

        String nameOfMonth = displayMonth(month);
        int daysInMonth = displayDaysInMonth(month, year);
        int dayOne = displayDayOne(month, year);

        System.out.println(); // For extra line
        System.out.println(nameOfMonth + " " + year);
        System.out.println(); // For extra line
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // First loop for correct indentation
        for(int i=0; i<dayOne; i++) {
            System.out.print("    ");
        }

        // Second loop for printing days
        for(int i=1; i<=daysInMonth; i++) {
            System.out.printf("%3d ", i);

            if((i + dayOne) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
