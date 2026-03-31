import java.time.LocalDate; // Class for date without time
import java.util.Scanner;

public class DateArithematic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a date in this format (yyyy-mm-dd): ");
        LocalDate date = LocalDate.parse(sc.next());

        // Adding 7 days, 1 month, and 2 years to the date entered using built-in methods
        LocalDate addDate = date.plusDays(7).plusMonths(1).plusYears(2);

        // Subtracting 3 weeks from the resulted date using built-in methods
        LocalDate localDate = addDate.minusWeeks(3);

        // Displaying the results
        System.out.println("\nOriginal Date is:  " + date); // Original date
        System.out.println("After Addition the date becomes:  " + addDate); // Added date
        System.out.println("After Subtraction the final date is:  " + localDate); // Subtracted date
    }
}
