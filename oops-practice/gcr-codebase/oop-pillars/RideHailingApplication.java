import java.util.Scanner;

// Creating an interface named GPS for location
interface GPS {
    void getCurrentLocation();
    void updateLocation(String location);
}

// Creating an abstract class named Vehicle with attributes
abstract class Vehicles {

    // Creating private attributes(Encapsulated)
    private int vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation = "Not Updated"; // GPS related data

    // Creating a constructor of the class
    public Vehicles(int vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Creating a getter method for vehicle id
    public int getVehicleId() {
        return vehicleId;
    }

    // Creating a getter method for driver name
    public String getDriverName() {
        return driverName;
    }

    // Creating a getter method for rate 
    protected double getRatePerKm() {
        return ratePerKm;
    }

    // Creating a setter method for current location
    protected void setCurrentLocation(String location) {
        this.currentLocation = location;
    }

    // Creating a getter method for current location
    protected String getCurrentLocationValue() {
        return currentLocation;
    }

    // Creating a concrete method to display the vehicle details
    public void getVehicleDetails() {
        System.out.println("Vehicle ID is: " + vehicleId);
        System.out.println("Name of the Driver is: " + driverName);
        System.out.println("Rate per KM is: INR " + ratePerKm);
        System.out.println("Current Location of the vehicle is: " + currentLocation);
    }

    // Creating an abstract method to calculate the fare
    abstract double calculateFare(double distance);
}

// Creating a subclass named Car(use GPS)
class Cars extends Vehicles implements GPS {

	// Creating a constructor using super keyword
    public Cars(int vehicleId, String driverName) {
        super(vehicleId, driverName, 10); // ₹10 per km
    }

    // Creating a method to calculate the fare
    @Override
    double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    // Creating a method to display the current location of the vehicle
    @Override
    public void getCurrentLocation() {
        System.out.println("Current Location: " + getCurrentLocationValue());
    }

    // Creating a method to update the location of the vehicle
    @Override
    public void updateLocation(String location) {
        setCurrentLocation(location);
    }
}

// Creating a subclass named Bike(use GPS)
class Bikes extends Vehicles implements GPS {

	// Creating a constructor using super keyword
    public Bikes(int vehicleId, String driverName) {
        super(vehicleId, driverName, 8); // ₹8 per km
    }

    // Creating a method to calculate the fare
    @Override
    double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    // Creating a method to display the current location of the vehicle
    @Override
    public void getCurrentLocation() {
        System.out.println("Current Location: " + getCurrentLocationValue());
    }

    // Creating a method to update the location of the vehicle
    @Override
    public void updateLocation(String location) {
        setCurrentLocation(location);
    }
}

// Creating a subclass named Auto(use GPS)
class Auto extends Vehicles implements GPS {

	// Creating a constructor using super keyword
    public Auto(int vehicleId, String driverName) {
        super(vehicleId, driverName, 10); // ₹10 per km
    }

    // Creating a method to calculate the fare
    @Override
    double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    // Creating a method to display the current location of the vehicle
    @Override
    public void getCurrentLocation() {
        System.out.println("Current Location: " + getCurrentLocationValue());
    }

    // Creating a method to update the location of the vehicle
    @Override
    public void updateLocation(String location) {
        setCurrentLocation(location);
    }
}


public class RideHailingApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		 
		System.out.println("Enter the number of vehicles you have: ");
		int number = sc.nextInt();
		 
	    Vehicles[] vehicles = new Vehicles[number]; 

	    for(int i=0; i<number; i++) {
	    	 
	        System.out.println("Ride Hailing Application");
		    System.out.println("1. Car");
		    System.out.println("2. Bike");
		    System.out.println("3. Auto");

		    // Asking the user to enter the choice
		    System.out.print("\nChoose Vehicle Type: ");
		    int choice = sc.nextInt();
		    sc.nextLine();

		    System.out.print("Enter Vehicle ID: ");
		    int vehicleId = sc.nextInt();
		    sc.nextLine();
		        
		    // Loop for name validation
		    String driverName;
		    while(true) {
		        System.out.print("Enter Driver Name (alphabets only): ");
		        driverName = sc.nextLine();

		        if(driverName.matches("[a-zA-Z ]+")) {
		            break;
		        } else {
		            System.out.println("Invalid input! Only alphabets allowed.");
		        }
            }

		    // Switch case for object creation for different choices
		    switch (choice) {
		     	case 1:
		            vehicles[i] = new Cars(vehicleId, driverName);
		            break;
		     	case 2:
		            vehicles[i] = new Bikes(vehicleId, driverName);
		            break;
		     	case 3:
		            vehicles[i] = new Auto(vehicleId, driverName);
		            break;
		     	default:
		            System.out.println("Invalid choice!");		              
		            return;
		    }

		    System.out.print("Enter Distance (in km): ");
		    double distance = sc.nextDouble();
		    sc.nextLine();

		    System.out.print("Update Current Location: ");
		    String location = sc.nextLine();
		    ((GPS) vehicles[i]).updateLocation(location);
		      
		    // Condition to check if anything else is entered by user in location field except alphabets
		    if(!location.matches("[a-zA-Z ]+")) {
		        System.out.println("Invalid location name! Only alphabets are allowed.");
		       	i--; // For repeating the iteration
		       	continue;
		    }
	    }

	    System.out.println("\n===== Fare Details =====");
	    System.out.println();
	     
	    for(Vehicles v : vehicles) {
	        System.out.print("Enter distance for Vehicle ID " + v.getVehicleId() + ": ");
	        double distance = sc.nextDouble();
	        sc.nextLine();

	        v.getVehicleDetails();
	        System.out.println("Total Fare: INR " + v.calculateFare(distance));
	        System.out.println("--------------------------------------");
	    }

	}

}
