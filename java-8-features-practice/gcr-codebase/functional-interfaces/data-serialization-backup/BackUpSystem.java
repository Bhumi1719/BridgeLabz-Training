import java.util.Scanner;

public class BackUpSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose object to backup:");
        System.out.println("1. Employee (Serializable)");
        System.out.println("2. Temporary File (Not Serializable)");

        System.out.print("\nEnter your choice: ");

        int choice = sc.nextInt();
        sc.nextLine(); 

        switch (choice) {

            case 1:
                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Employee Name: ");
                String name = sc.nextLine();

                Employee emp = new Employee(id, name);
                BackUpProcessor.backupObject(emp);
                break;

            case 2:
                System.out.print("Enter temporary data: ");
                String data = sc.nextLine();

                TemporaryFile temp = new TemporaryFile(data);
                BackUpProcessor.backupObject(temp);
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }
}