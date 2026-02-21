import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TrafficFineSystem system = new TrafficFineSystem();

        while(true) {
            System.out.println("\n1. Record Violation");
            System.out.println("2. Calculate Fine");
            System.out.println("3. Generate Monthly Report");
            System.out.println("4. Exit");

            System.out.print("\nChoose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter Vehicle Number: ");
                        String vehicle = sc.nextLine();

                        System.out.println("Select Violation Type:");
                        System.out.println("1. Speeding");
                        System.out.println("2. Signal Jump");

                        int type = sc.nextInt();

                        Violation violation = null;

                        if(type == 1) {
                            violation = new SpeedingViolation();
                        } else if(type == 2) {
                            violation = new SignalJumpViolation();
                        } else {
                            System.out.println("Invalid violation type!");
                            continue;
                        }

                        system.recordViolation(vehicle, violation);
                        System.out.println("Violation Recorded Successfully!");
                        break;

                    case 2:
                        System.out.print("Enter Vehicle Number: ");
                        String v = sc.nextLine();

                        double total = system.calculateTotalFine(v);
                        System.out.println("Total Fine: ₹" + total);
                        break;

                    case 3:
                        system.generateMonthlyReport();
                        break;

                    case 4:
                        System.out.println("Exited");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (InvalidVehicleException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}