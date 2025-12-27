import java.time.LocalDate;                 // Class for date without time
import java.time.format.DateTimeFormatter;  // Class for formatting date

public class DateFormat {
    public static void main(String[] args) {

        // For getting the current date
        LocalDate date = LocalDate.now();

        // Creating DateTimeFormatter objects for different patterns
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // With day at the beginning
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // With year at the beginning
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy"); // With name of the day at beginning

        // Displaying the date in different formats
        System.out.println("\nDate Format (dd/MM/yyyy):  " + date.format(formatter1));
        System.out.println("Date Format (yyyy-MM-dd):  " + date.format(formatter2));
        System.out.println("Date Format (EEE, MMM dd, yyyy):  " + date.format(formatter3));
    }
}
