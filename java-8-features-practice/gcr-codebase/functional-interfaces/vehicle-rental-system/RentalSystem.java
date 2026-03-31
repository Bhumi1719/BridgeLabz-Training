import java.util.Scanner;

public class RentalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vehicleChoice;
        int actionChoice;

        do{
            System.out.println("\nChoose Vehicle:");
            System.out.println("1. Car");
            System.out.println("2. Bike");
            System.out.println("3. Bus");
            System.out.println("4. Exit");

            System.out.print("\nEnter your choice: ");
            vehicleChoice = sc.nextInt();

            Vehicle vehicle = null;

            switch (vehicleChoice) {
                case 1 : 
                    vehicle = new Car(); 
                    break;
                case 2 : 
                    vehicle = new Bike(); 
                    break;
                case 3 : 
                    vehicle = new Bus(); 
                    break;
                case 4 :
                    System.out.println("Exited");
                    continue;
                default:
                    System.out.println("Invalid choice");
                    continue;
            }

            System.out.println("1. Rent");
            System.out.println("2. Return");

            System.out.print("\nEnter your action: ");
            actionChoice = sc.nextInt();

            switch (actionChoice) {
                case 1 : 
                    vehicle.rent(); 
                    break;
                case 2 : 
                    vehicle.returnVehicle(); 
                    break;
                default : 
                    System.out.println("Invalid action!");
            }

        } while(vehicleChoice != 4);
    }
}
