import java.util.*;

public class VehicleRentalApp {

    // Creating a list of vehicles
    static List<Vehicle> vehicles = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while(true) {
            System.out.println("\n1.Add Vehicle");
            System.out.println("2.View Vehicles");
            System.out.println("3.Update Vehicle");
            System.out.println("4.Delete Vehicle");
            System.out.println("5.Rent Vehicle");
            System.out.println("6.Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1 :
                    addVehicle();
                    System.out.println("Vehicle added successfully");
                    break;
                case 2 :
                    viewVehicles();
                    break;
                case 3 :
                    updateVehicle();
                    break;
                case 4 :
                    deleteVehicle();
                    break;
                case 5 :
                    rentVehicle();
                    break;
                case 6 :
                    System.out.println("Exited Successfully");
                    System.exit(0);
                default :
                    System.out.println("Invalid Choice");
            }
        }
    }

    // Creating a method to add vehicle
    public static void addVehicle() {
        System.out.println("1.Bike 2.Car 3.Truck");
        System.out.print("\nEnter vehicle type: ");
        int type = sc.nextInt();

        System.out.print("Vehicle ID: ");
        int id = sc.nextInt();

        System.out.print("Brand: ");
        String brand;

        // Validation for name
        while(true) {
            brand = sc.next();
            if(brand.matches("[a-zA-Z]+")) {
                break;
            } else {
                System.out.print("Invalid name! Enter alphabets only: ");
            }
        }
        System.out.print("Price Per Day: ");
        double price = sc.nextDouble();

        if(type == 1)
            vehicles.add(new Bike(id, brand, price));
        else if(type == 2)
            vehicles.add(new Car(id, brand, price));
        else
            vehicles.add(new Truck(id, brand, price));
    }

    // Creating a method to view vehicles
    public static void viewVehicles() {
        for(Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
        }
    }

    // Creating a method to update vehicle details
    public static void updateVehicle() {

        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();

        for(Vehicle vehicle : vehicles) {
            if(vehicle.vehicleId == id) {
                System.out.print("New Brand: ");

                // Validation for name
                while (true) {
                    String newBrand = sc.next();
                    if (newBrand.matches("[a-zA-Z]+")) {
                        vehicle.brand = newBrand;
                        break;
                    } else {
                    System.out.print("Invalid name! Enter alphabets only: ");
                }
            }
                System.out.print("New Price/Day: ");
                vehicle.pricePerDay = sc.nextDouble();
                System.out.println("Updated Successfully");
                return;
            }
        }
        System.out.println("Vehicle Not Found");
    }

    // Creating a method to rent vehicle
    public static void rentVehicle() {

        System.out.print("Enter Vehicle ID: ");
        int vehicleId = sc.nextInt();

        for(Vehicle vehicle : vehicles) {
            if(vehicle.vehicleId == vehicleId && vehicle instanceof Rentable) {

                System.out.print("Customer ID: ");
                int customerId = sc.nextInt();

                System.out.print("Customer Name: ");
                String customerName;

                // Validation for name
                while(true) {
                    customerName = sc.next();
                    if(customerName.matches("[a-zA-Z]+")) {
                        break;
                    }
                    System.out.print("Enter alphabets only: ");
                }

                Customer customer = new Customer(customerId, customerName);

                System.out.print("Enter number of days: ");
                int days = sc.nextInt();

                double rent = ((Rentable) vehicle).calculateRent(days);

                System.out.println("\nRENT DETAILS ");
                System.out.println("Customer: " + customer.name);
                vehicle.displayInfo();
                System.out.println("Days: " + days);
                System.out.println("Total Rent: INR " + rent);
                return;
            }   
        }
        System.out.println("Vehicle Not Found");
    }   


    // Creating a method to delete vehicle
    public static void deleteVehicle() {
        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();
        vehicles.removeIf(v -> v.vehicleId == id);
        System.out.println("Deleted Successfully");
    }
}
