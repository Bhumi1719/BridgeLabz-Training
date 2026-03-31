import java.time.LocalDate;
import java.util.Scanner;

public class InsurancePolicy {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PolicyManager manager = new PolicyManager();

        while(true) {
            System.out.println("\n1. Add Policy");
            System.out.println("2. Get Policy by Number");
            System.out.println("3. Policies Expiring in Next 30 Days");
            System.out.println("4. Policies by Policyholder");
            System.out.println("5. Remove Expired Policies");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Policy Number: ");
                    int number = sc.nextInt();

                    System.out.print("Policy Holder Name: ");
                    String holder = sc.next();

                    System.out.print("Expiry Date (yyyy-mm-dd): ");
                    LocalDate date = LocalDate.parse(sc.next());

                    System.out.print("Coverage Type: ");
                    String coverage = sc.next();

                    System.out.print("Premium Amount: ");
                    double premium = sc.nextDouble();

                    manager.addPolicy(new Policy(number, holder, date, coverage, premium));
                    System.out.println("Policy added successfully");
                    break;

                case 2:
                    System.out.print("Enter Policy Number: ");
                    int pno = sc.nextInt();
                    System.out.println(manager.getPolicyByNumber(pno));
                    break;

                case 3:
                    manager.getPoliciesExpiringIn30Days();
                    break;

                case 4:
                    System.out.print("Enter Policyholder Name: ");
                    String name = sc.next();
                    manager.getPoliciesByHolder(name);
                    break;

                case 5:
                    manager.removeExpiredPolicies();
                    System.out.println("Expired policies removed");
                    break;

                case 6:
                    System.out.println("Exited");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
