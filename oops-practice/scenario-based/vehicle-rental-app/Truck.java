// Creating a subclass named Truck which extends Vehicle(Rentable)
public class Truck extends Vehicle implements Rentable {

    public Truck(int vehicleId, String brand, double pricePerDay) {
        super(vehicleId, brand, pricePerDay);
    }

    // Creating a method to calculate the rent of the vehicle
    @Override
    public double calculateRent(int days) {
        return (pricePerDay * days) + 1000; // heavy vehicle charge
    }

    // Creating a method to display the detials of the vehicle
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Truck");
    }
}

