import java.util.*;

public class EmailNotifications {

    public static void sendEmailNotification(String email) {
        System.out.println("Notification sent to: " + email);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> emails = new ArrayList<>();

        System.out.print("Enter number of users: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for(int i=0; i<n; i++) {
            System.out.print("Enter user email: ");
            emails.add(sc.nextLine());
        }

        System.out.println();
        // Using forEach with lambda to send notifications
        emails.forEach(email -> sendEmailNotification(email));
    }
}
