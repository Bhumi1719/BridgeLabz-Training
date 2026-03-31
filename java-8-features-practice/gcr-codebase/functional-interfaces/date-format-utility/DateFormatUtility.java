import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateFormatUtility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter date in format yyyy-MM-dd (e.g., 2026-02-03): ");
        String inputDate = sc.nextLine();

        try {
            // Converting input string to Date object
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = inputFormat.parse(inputDate);

            // Displaying in multiple formats using static interface method
            System.out.println("\nFormatted Dates:");
            System.out.println("dd/MM/yyyy : " + DateUtils.formatDate(date, "dd/MM/yyyy"));
            System.out.println("MM-dd-yyyy : " + DateUtils.formatDate(date, "MM-dd-yyyy"));
            System.out.println("EEEE, MMMM dd, yyyy : " + DateUtils.formatDate(date, "EEEE, MMMM dd, yyyy"));

        } catch (Exception e) {
            System.out.println("Invalid date format! Please use yyyy-MM-dd.");
        }
    }
}