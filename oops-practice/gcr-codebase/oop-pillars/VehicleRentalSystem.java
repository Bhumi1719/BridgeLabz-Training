import java.util.*;

// Creating an interface named Insurable for insurance-related operations
interface Insurable {

	// Creating a method to calculate insurance cost
	double calculateInsurance();

	// Creating a method to return insurance details
	String getInsuranceDetails();
}

// Creating an abstract class named Vehicle with attributes
abstract class Vehicle {

	// Creating private attributes(Encapsulated fields)
	private String vehicleNumber;     
	private String type;
	
	// Creating protected attribute(accessible to subclasses)
	protected double rentalRate;      

	// Creating a constructor of the class
	public Vehicle(String vehicleNumber, String type, double rentalRate) {
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.rentalRate = rentalRate;
	}

	// Creating a getter method for vehicle number
	public String getVehicleNumber() {
		return vehicleNumber;
	}

	// Creating a getter method for vehicle type
	public String getType() {
	 	return type;
	}

	// Creating an abstract method to calculate the rental cost
	public abstract double calculateRentalCost(int days);

	// Creating a concrete method to display vehicle details
	public void displayDetails() {
		System.out.println("Vehicle Number is: " + vehicleNumber);
		System.out.println("Vehicle Type is: " + type);
		System.out.println("Rental Rate of the vehicle is: " + rentalRate + " per day");
	}
}

// Creating a subclass named Car(Insuranced Vehicle)
class Car extends Vehicle implements Insurable {
	
	private String insurancePolicyNo;

	// Creating a constructor using the super keyword
	public Car(String vehicleNumber, double rentalRate, String policyNo) {
		super(vehicleNumber, "Car", rentalRate);
		this.insurancePolicyNo = policyNo;
	}

	// Creating a method to calculate the rental cost for car
	@Override
	public double calculateRentalCost(int days) {
		return rentalRate * days;
	}

	// Creating a method for insurance calculation for car (20% of rental rate)
	@Override
	public double calculateInsurance() {
		return rentalRate * 0.20;
	}

	// Creating a method to get the insurance details
	@Override
	public String getInsuranceDetails() {
		return "Car Insurance (Policy No: " + insurancePolicyNo + ")";
	}
}

// Creating a subclass named bike(Insuranced Vehicle)
class Bike extends Vehicle implements Insurable {

	private String insurancePolicyNo;

	// Creating a constructor using the super keyword
	public Bike(String vehicleNumber, double rentalRate, String policyNo) {
		super(vehicleNumber, "Bike", rentalRate);
		this.insurancePolicyNo = policyNo;
	}

	// Creating a method to calculate the rental cost for bike
	@Override
	public double calculateRentalCost(int days) {
		return rentalRate * days;
	}

	// Creating a method for insurance calculation for bike (5% of rental rate)
	@Override
	public double calculateInsurance() {
		return rentalRate * 0.05;
	}

	// Creating a method to get the insurance details
	@Override
	public String getInsuranceDetails() {
		return "Bike Insurance (Policy No: " + insurancePolicyNo + ")";
	}
}

// Creating a subclass named bike(Insuranced Vehicle)
class Truck extends Vehicle implements Insurable {

	private String insurancePolicyNo;

	//Creating a constructor using the super keyword
	public Truck(String vehicleNumber, double rentalRate, String policyNo) {
		super(vehicleNumber, "Truck", rentalRate);
		this.insurancePolicyNo = policyNo;
	}

	//Creating a method to calculate the rental cost for truck
	@Override
	public double calculateRentalCost(int days) {
		return (rentalRate * days) + 1000; // extra maintenance charge
	}

	//Creating a method for insurance calculation for truck (10% of rental rate)
	@Override
	public double calculateInsurance() {
		return rentalRate * 0.10;
	}

	// Creating a method to get the insurance details
	@Override
	public String getInsuranceDetails() {
		return "Truck Insurance (Policy No: " + insurancePolicyNo + ")";
	}
}

public class VehicleRentalSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Scanner sc = new Scanner(System.in);
        
        // Creating a list of vehices
        List<Vehicle> vehicles = new ArrayList<>();

        // Asking the user to enter number of vehicles
        System.out.print("Enter number of vehicles: ");
        int numberOfVehicles = sc.nextInt();
        
        sc.nextLine(); // consume newline

        // Loop for taking vehicle details
        for(int i=0; i<numberOfVehicles; i++) {

            System.out.println("\nEnter vehicle type (Car/Bike/Truck): ");
            String type = sc.nextLine();

            System.out.print("Enter the vehicle number: ");
            String number = sc.nextLine();

            System.out.print("Enter the rental rate per day: ");
            double rate = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter the insurance policy number: ");
            String policy = sc.nextLine();

            // Creating object based on the type of vehicle
            if (type.equalsIgnoreCase("Car")) {
                vehicles.add(new Car(number, rate, policy));
            } else if (type.equalsIgnoreCase("Bike")) {
                vehicles.add(new Bike(number, rate, policy));
            } else if (type.equalsIgnoreCase("Truck")) {
                vehicles.add(new Truck(number, rate, policy));
            } else {
                System.out.println("Invalid vehicle type");
            }
        }

        System.out.print("\nEnter number of rental days: ");
        int days = sc.nextInt();

        System.out.println("\nVehicle Details");
        System.out.println();
        
        // Polymorphism demonstration
        for (Vehicle v : vehicles) {
            v.displayDetails();

            System.out.println("Rental Cost: " + v.calculateRentalCost(days));

            Insurable insurance = (Insurable) v;
            System.out.println(insurance.getInsuranceDetails());
            System.out.println("Insurance Cost: " + String.format("%.2f", insurance.calculateInsurance()));
            System.out.println("------------------------------");
        }
	}

}
