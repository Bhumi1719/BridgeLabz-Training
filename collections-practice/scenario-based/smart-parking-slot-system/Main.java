import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ParkingSystem system = new ParkingSystem();

        // Method to Add Slots
        System.out.print("Enter number of slots: ");
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            System.out.print("Enter slot number: ");
            int slotNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter slot type (Car/Bike): ");
            String type = sc.nextLine();

            system.addSlot(new ParkingSlot(slotNo, type));
        }

        // Method to Add Vehicles
        System.out.print("\nEnter number of vehicles: ");
        int v = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<v; i++) {
            System.out.print("Enter vehicle type (Car/Bike): ");
            String type = sc.nextLine();

            System.out.print("Enter vehicle number: ");
            String number = sc.nextLine();

            if(type.equalsIgnoreCase("Car")) {
                system.addVehicle(new Car(number));
            } else {
                system.addVehicle(new Bike(number));
            }
        }

        system.allocateSlots();
    }
}
