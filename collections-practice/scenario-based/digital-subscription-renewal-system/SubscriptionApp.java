import java.time.LocalDate;
import java.util.Scanner;

public class SubscriptionApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SubscriptionManager manager = new SubscriptionManager();

        System.out.print("Enter number of users: ");
        int n = sc.nextInt();
        sc.nextLine();  

        for(int i=0; i<n; i++) {

            System.out.println("\nEnter details for User " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Subscription Fee: ");
            double fee = sc.nextDouble();

            System.out.print("Days until expiry (negative if already expired): ");
            int days = sc.nextInt();
            sc.nextLine();

            LocalDate expiryDate = LocalDate.now().plusDays(days);

            manager.addUser(new User(name, expiryDate, fee));
        }

        System.out.println("\nChoose Discount Type:");
        System.out.println("1. No Discount");
        System.out.println("2. Festival Discount (20%)");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        DiscountStrategy strategy;

        if(choice == 2) {
            strategy = new FestivalDiscount();
        } else {
            strategy = new NoDiscount();
        }

        try {
            manager.autoRenew(strategy);
        } catch (PaymentDeclinedException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nExpired Users:");
        manager.showExpiredUsers();
    }
}
