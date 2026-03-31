import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsurancePolicy {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PolicyManager manager = new PolicyManager();
        List<Policy> allPolicies = new ArrayList<>();

        while(true) {
            System.out.println("\n1. Add Policy");
            System.out.println("2. Display All Policies");
            System.out.println("3. Policies Expiring Soon");
            System.out.println("4. Policies by Coverage Type");
            System.out.println("5. Display Duplicate Policies");
            System.out.println("6. Compare Performance");
            System.out.println("7. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Policy Number: ");
                    int number = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Policyholder Name: ");
                    String holder = sc.nextLine();

                    System.out.print("Expiry Date (yyyy-mm-dd): ");
                    LocalDate expiry = LocalDate.parse(sc.next());

                    System.out.print("Coverage Type: ");
                    String coverage = sc.next();

                    System.out.print("Premium Amount: ");
                    double premium = sc.nextDouble();

                    Policy p = new Policy(number, holder, expiry, coverage, premium);
                    manager.addPolicy(p);
                    allPolicies.add(p);
                    break;

                case 2:
                    manager.displayAllPolicies();
                    break;

                case 3:
                    manager.displayPoliciesExpiringSoon();
                    break;

                case 4:
                    System.out.print("Enter coverage type: ");
                    String type = sc.next();
                    manager.displayPoliciesByCoverage(type);
                    break;

                case 5:
                    manager.displayDuplicatePolicies(allPolicies);
                    break;

                case 6:
                    if(!allPolicies.isEmpty()) {
                        manager.comparePerformance(allPolicies.get(0));
                    } else {
                        System.out.println("No policies to test performance.");
                    }
                    break;

                case 7:
                    System.out.println("Exited");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
