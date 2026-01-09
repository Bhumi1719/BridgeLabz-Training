// Creating a class named Vehicle with attributes
public class Vehicle {
    protected int vehicleId;
    protected String brand;
    protected double pricePerDay;

    // Creating a constructor of the class
    public Vehicle(int vehicleId, String brand, double pricePerDay) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.pricePerDay = pricePerDay;
    }

    // Creating a method to display the details
    public void displayInfo() {
        System.out.println("ID: " + vehicleId + ", Brand: " + brand + ", Price/Day: " + pricePerDay);
    }
}

