import java.util.*;

public class SpringSeason {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking input from scanner rather than from command line
        System.out.print("Month is: ");
        int month = sc.nextInt();

        System.out.print("Day of the month is: ");
        int day = sc.nextInt();

        // Calling the function 
        boolean isSeason = isSpringSeason(month, day);
        System.out.println(isSeason);
    }

    // Method for finding whether it is a spring season or not
    public static boolean isSpringSeason(int month, int day) {
        if(month == 3 && day >= 20 || month == 4 || month == 5 || month == 6 && day <= 20) {
            return true;
        } 
        return false;
    }
}