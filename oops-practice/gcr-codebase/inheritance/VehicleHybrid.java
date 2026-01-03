import java.util.Scanner;

interface Refuelable {
    void refuel();
}

// Creating a class with attributes
class VehicleH {
    int maxSpeed;
    String model;

    // Creating a constructor of the class
    VehicleH(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    // Creating a method to display the details of the vehicle
    void displayDetails() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Creating a subclass with attributes
class ElectricVehicle extends VehicleH {
    int batteryCapacity; // in kWh

    // Creating a constructor using super keyword
    ElectricVehicle(int maxSpeed, String model, int batteryCapacity) {
        super(maxSpeed, model);
        this.batteryCapacity = batteryCapacity;
    }

    // Creating a method to display the charging capacity details of the vehicle
    void charge() {
        System.out.println("Charging electric vehicle with " + batteryCapacity + " kWh battery");
    }
}

// Creating a subclass with attributes
class PetrolVehicle extends VehicleH implements Refuelable {
    int fuelTankCapacity; // in liters

    // Creating a constructor using super keyword
    PetrolVehicle(int maxSpeed, String model, int fuelTankCapacity) {
        super(maxSpeed, model);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    // Creating a method to display refueling detials of the vehicle
    public void refuel() {
        System.out.println("Refueling petrol vehicle with " + fuelTankCapacity + " liters capacity");
    }
}

public class VehicleHybrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        // Electric Vehicle input
        System.out.println("Enter Electric Vehicle Details:");
        System.out.print("Model: ");
        String eModel = sc.nextLine();
        System.out.print("Max Speed: ");
        int eSpeed = sc.nextInt();
        System.out.print("Battery Capacity (kWh): ");
        int battery = sc.nextInt();
        sc.nextLine();

        ElectricVehicle ev = new ElectricVehicle(eSpeed, eModel, battery);

        // Petrol Vehicle input
        System.out.println("\nEnter Petrol Vehicle Details:");
        System.out.print("Model: ");
        String pModel = sc.nextLine();
        System.out.print("Max Speed: ");
        int pSpeed = sc.nextInt();
        System.out.print("Fuel Tank Capacity (liters): ");
        int fuel = sc.nextInt();

        PetrolVehicle pv = new PetrolVehicle(pSpeed, pModel, fuel);

        // Display details
        System.out.println("\n Vehicle Information");
        System.out.println();

        ev.displayDetails();
        ev.charge();
        System.out.println("--------------------");

        pv.displayDetails();
        pv.refuel();
	}

}
