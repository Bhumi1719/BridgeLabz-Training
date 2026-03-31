import java.time.LocalDate;   // Class for date without time
import java.util.Scanner;    

public class DateComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first date in the format(yyyy-mm-dd): ");
        LocalDate date1 = LocalDate.parse(sc.next());

        System.out.print("Enter second date in the format(yyyy-mm-dd): ");
        LocalDate date2 = LocalDate.parse(sc.next());

        // Conditionals for comparing both the dates entered by the user
        if(date1.isBefore(date2)) { // Condition for before
            System.out.println("\nFirst date is BEFORE the second date");
        } else if(date1.isAfter(date2)) { // Condition for after
            System.out.println("\nFirst date is AFTER the second date");
        } else if(date1.isEqual(date2)) { // Condition for equal
            System.out.println("\nBoth dates are SAME");
        }
    }
}
