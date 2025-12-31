// Creating a class named vehicle with attributes
class Vehicle {
	// Creating Instance Variables
    String ownerName;
    String vehicleType;

    // Creating a Class Variable
    static double registrationFee = 1500.0;

    // CReating a constructor of the class
    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Creating an Instance Method to display the details of the vehicle
    void displayVehicleDetails() {
        System.out.println("Owner of the vehicle is: " + ownerName);
        System.out.println("Type of vehicle is: " + vehicleType);
        System.out.println("Registration Fee is INR " + registrationFee);
    }

    // Creating a Class Method to update the registration fees
    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }
	
}
public class VehicleRegistration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creating an object of the class to call it by name for vehicle1
		Vehicle vehicle1 = new Vehicle("Abhishek", "Car");
		vehicle1.displayVehicleDetails(); // Calling the method to display vehicle details
		
		System.out.println(); // For extra line
		
		// Creating an object of the class to call it by name for vehicle2
        Vehicle vehicle2 = new Vehicle("Ayush", "Bike");
        vehicle2.displayVehicleDetails(); // Calling the method to display vehicle details
        
        System.out.println("---------------------------------");

        // Calling the class method to update the registration fees 
        Vehicle.updateRegistrationFee(2000.0);

        vehicle1.displayVehicleDetails(); // Calling the method again to display vehicle details
        System.out.println(); // For extra line
        vehicle2.displayVehicleDetails(); // Calling the method againto display vehicle details
	}

}
