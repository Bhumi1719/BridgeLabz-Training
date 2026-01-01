// Creating a class named Vehicle with different types of attributes
class Vehicle {
    // Creating static variable(shared by all)
    static double REGISTRATION_FEE = 150.0;

    // Creating instance variables
    String ownerName;
    String vehicleType;

    // Creating final variable(cannot be changed)
    final String registrationNumber;

    // Creating a constructor of the class
    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;                   
        this.vehicleType = vehicleType;               
        this.registrationNumber = registrationNumber; 
    }

    // Creating a static method to update the registration fees
    static void updateRegistrationFee(double fee) {
        REGISTRATION_FEE = fee;
    }

    // Creating a method using instanceof to check obj type
    void displayDetails(Object obj) {
        if (obj instanceof Vehicle) { // Condition to check if obj belongs to the class vehicle
            Vehicle vehicle = (Vehicle) obj; // type casting

            System.out.println("Owner Name: " + vehicle.ownerName);
            System.out.println("Vehicle Type: " + vehicle.vehicleType);
            System.out.println("Registration Number: " + vehicle.registrationNumber);
            System.out.println("Registration Fee: $" + REGISTRATION_FEE);
        }
    }
}

public class VehicleRegistrationSystem {
    public static void main(String[] args) {
        // Creating an object of the class for vehicle1
        Vehicle vehicle1 = new Vehicle("Honest raj", "Sedan", "ABC123");

        // Creating an object of the class for vehicle2
        Vehicle vehicle2 = new Vehicle("Price danish", "SUV", "XYZ789");

        vehicle1.displayDetails(vehicle1); // Calling the method to display details of vehicle1
        vehicle2.displayDetails(vehicle2); // Calling the method to display details of vehicle1
    }
}