import java.util.*;
import java.util.function.Predicate;

public class NotificationFiltering {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Alert> alerts = new ArrayList<>();
        alerts.add(new Alert("Heart rate critical", "EMERGENCY"));
        alerts.add(new Alert("Time to take medicine", "MEDICATION"));
        alerts.add(new Alert("Appointment reminder", "GENERAL"));

        System.out.println("\nChoose alert type to display:");
        System.out.println("1. EMERGENCY");
        System.out.println("2. MEDICATION");
        System.out.println("3. GENERAL");

        System.out.print("\nEnter your choice: ");
        int choice = sc.nextInt();

        Predicate<Alert> filter;

        switch (choice) {
            case 1:
                filter = alert -> alert.type.equals("EMERGENCY");
                break;
            case 2:
                filter = alert -> alert.type.equals("MEDICATION");
                break;
            case 3:
                filter = alert -> alert.type.equals("GENERAL");
                break;
            default:
                System.out.println("Invalid choice");
                sc.close();
                return;
        }

        System.out.println("\nFiltered Alerts:");
        alerts.stream().filter(filter).forEach(System.out::println);

        sc.close();
    }
}