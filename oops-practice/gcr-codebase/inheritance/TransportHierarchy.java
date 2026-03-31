import java.util.*; 

// Creating a class with attributes
class Vehicle {
    int maxSpeed;
    String fuelType;

    // Creating a constructor of the class
    Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    // Creating a method to display the details of the vehicle
    void displayInfo() {
        System.out.println("Max Speed of the vehicle is: " + maxSpeed + " km/h");
        System.out.println("Fuel Type of the vehicle is: " + fuelType);
    }
}

// Creating a subclass with attributes
class Car extends Vehicle {
    int seatCapacity;

    // Creating a constructor using super keyword
    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    // Creating a method to display the seat size of the vehicle
    void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity of the vehicle is: " + seatCapacity);
    }
}

// Creating a subclass with attributes
class Truck extends Vehicle {
    double loadCapacity; 

    // Creating a constructor using super keyword
    Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    // Creating a method to display the load capacity of the vehicle
    void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity of the vehicle is: " + loadCapacity + " tons");
    }
}

// Creating a subclass with attributes
class Motorcycle extends Vehicle {
    boolean hasGear;

    // Creating a constructor using super keyword
    Motorcycle(int maxSpeed, String fuelType, boolean hasGear) {
        super(maxSpeed, fuelType);
        this.hasGear = hasGear;
    }

    // Creating a method to display the details of the vehicle
    void displayInfo() {
        super.displayInfo();
        System.out.println("This vehicle has Gear: " + (hasGear ? "Yes" : "No"));
    }
}

public class TransportHierarchy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        Vehicle[] vehicles = new Vehicle[3];

        // Car input
        System.out.println("Enter Car Details:");
        System.out.print("Max Speed: ");
        int carSpeed = sc.nextInt();
        sc.nextLine();
        System.out.print("Fuel Type: ");
        String carFuel = sc.nextLine();
        System.out.print("Seat Capacity: ");
        int seats = sc.nextInt();

        vehicles[0] = new Car(carSpeed, carFuel, seats);

        // Truck input
        System.out.println("\nEnter Truck Details:");
        System.out.print("Max Speed: ");
        int truckSpeed = sc.nextInt();
        sc.nextLine();
        System.out.print("Fuel Type: ");
        String truckFuel = sc.nextLine();
        System.out.print("Load Capacity (tons): ");
        double load = sc.nextDouble();

        vehicles[1] = new Truck(truckSpeed, truckFuel, load);

        // Motorcycle input
        System.out.println("\nEnter Motorcycle Details:");
        System.out.print("Max Speed: ");
        int bikeSpeed = sc.nextInt();
        sc.nextLine();
        System.out.print("Fuel Type: ");
        String bikeFuel = sc.nextLine();
        System.out.print("Has Gear (true/false): ");
        boolean gear = sc.nextBoolean();

        vehicles[2] = new Motorcycle(bikeSpeed, bikeFuel, gear);

        System.out.println("\n--- Vehicle Information ---");
        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println("-----------------------------------------");
        }

	}

}
