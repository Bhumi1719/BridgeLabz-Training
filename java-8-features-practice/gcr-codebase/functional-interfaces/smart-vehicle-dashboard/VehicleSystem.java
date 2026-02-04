import java.util.Scanner;

public class VehicleSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nVehicles Available");
            System.out.println("1. Petrol Car");
            System.out.println("2. Electric Car");
            System.out.println("3. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            Vehicle vehicle = null;

            switch (choice) {
                case 1:
                    vehicle = new PetrolCar();
                    break;
                case 2:
                    vehicle = new ElectricCar();
                    break;
                case 3:
                    System.out.println("Exited");
                    continue;
                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            vehicle.displaySpeed();
            vehicle.displayBattery();

        } while (choice != 3);
    }
}