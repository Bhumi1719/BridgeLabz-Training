// Creating a subclass Car which extends Vehicle(Rentable)
public class Car extends Vehicle implements Rentable {

    public Car(int vehicleId, String brand, double pricePerDay) {
        super(vehicleId, brand, pricePerDay);
    }

    // Creating a method to calculate rent of the vehicle
    @Override
    public double calculateRent(int days) {
        return (pricePerDay * days) + 500; // extra charge
    }

    // Creating a method to display the details of the vehicle
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Car");
    }
}

