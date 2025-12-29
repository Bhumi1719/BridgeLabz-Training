import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LibraryReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TOTAL_FINE = 0; // Variable for storing the total fine calculated 
        int FINE_PER_DAY = 5; // Variable for storing the fine calculated for each late day

        // Loop for calculating fine for 5 days if returned late
        for(int i=1; i<=5; i++) {

            System.out.println("\nBook " + i);

            System.out.print("Enter due date for the book (YYYY-MM-DD): ");
            LocalDate dueDate = LocalDate.parse(sc.next());

            System.out.print("Enter return date for the book (YYYY-MM-DD): ");
            LocalDate returnDate = LocalDate.parse(sc.next());

            long lateDays = ChronoUnit.DAYS.between(dueDate, returnDate);

            // Condition for returning the book late
            if(lateDays > 0) {
                int fine = (int) lateDays * FINE_PER_DAY; // Calculating fine for each late days
                TOTAL_FINE += fine; // Calculating the total fine for late days

                System.out.println("\nLate by " + lateDays + " days");
                System.out.println("YOur fine till date is INR " + fine);
            } else {
                System.out.println("\nReturned on time");
                System.out.println("No fine to be given");
            }
        }

        // Displaying total fine for all books
        System.out.println("\nTotal Fine for 5 books is INR " + TOTAL_FINE);
    }
}