// Creating a subclass named Bike(Rentable)
public class Bike extends Vehicle implements Rentable {

    // Creating a constructor using super keyword
    public Bike(int vehicleId, String brand, double pricePerDay) {
        super(vehicleId, brand, pricePerDay);
    }

    // Creating a method to calculate rent of the vehicle
    @Override
    public double calculateRent(int days) {
        return pricePerDay * days;
    }

    // Creating a method to display the details of vehicle
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Bike");
    }
}

