import java.util.Scanner;

public class SensitiveDataSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Data Type:");
        System.out.println("1. User Credentials (Sensitive)");
        System.out.println("2. Public Info (Not Sensitive)");

        System.out.print("\nEnter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        switch (choice) {

            case 1:
                System.out.print("Enter Username: ");
                String username = sc.nextLine();

                System.out.print("Enter Password: ");
                String password = sc.nextLine();

                UserCredentials user = new UserCredentials(username, password);
                EncryptionProcessor.processData(user);
                break;

            case 2:
                System.out.print("Enter Public Message: ");
                String msg = sc.nextLine();

                PublicInfo info = new PublicInfo(msg);
                EncryptionProcessor.processData(info);
                break;

            default:
                System.out.println("Invalid choice!");
        }

    }
}