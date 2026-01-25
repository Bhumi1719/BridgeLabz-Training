import java.util.Scanner;

public class DayOfYear {
    
    public static int dayOfYear(String S) {
        String[] s = S.split("-");
        int year = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        int date = Integer.parseInt(s[2]);
        boolean isLeap = checkYear(year);
        int noOfDays = 0;

        final int[] DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for(int i = 0; i < month - 1; i++) {
            if(isLeap && i == 1) {
                noOfDays += DAYS[i] + 1;
                continue;
            }
            noOfDays += DAYS[i];
        }
        return noOfDays + date;
    }



    public static boolean checkYear(int year) {
        if(year % 400 == 0)
            return true;
        if(year % 100 == 0)
            return false;
        if(year % 4 == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter date in YYYY-MM-DD format: ");
        String date = sc.nextLine();

        int dayNumber = dayOfYear(date);
        System.out.println("Day number of the year: " + dayNumber);
    }
}
