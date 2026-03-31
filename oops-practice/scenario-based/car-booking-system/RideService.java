import java.util.*;

public class RideService {

	// Creating a list for drivers
    private List<Driver> drivers = new ArrayList<>();
    
    // Creating a list for rides
    private List<Ride> rides = new ArrayList<>();

    // Creating a method to add drivers
    public void addDriver(Driver driver) {
        drivers.add(driver);
        System.out.println("Driver added successfully");
    }

    // Creating a method to book rides
    public void bookRide(User user, double distance, FareCalculator calculator) throws NoDriverAvailableException {

        Driver driver = getAvailableDriver(); // Calling the method to get the driver
        double fare = calculator.calculateFare(distance); // Calling the method to calculate fare as per ride distance

        // Creating an object of ride each time ride is booked
        Ride ride = new Ride(user, driver, distance, fare);
        rides.add(ride); // Adding the ride to the list

        driver.isAvailable = false;

        System.out.println("\nRide booked successfully \nDriver name : " + driver.name + "\nFare: INR " + fare);

    }

    // Creating a method to get the available drivers
    private Driver getAvailableDriver() throws NoDriverAvailableException {
        for(Driver driver : drivers) {
            if(driver.isAvailable) {
            	return driver;
            }
        }
        throw new NoDriverAvailableException("No driver available");
    }
    
    public void completeRide(int index) {

        if(index < 0 || index >= rides.size()) {
            System.out.println("Invalid ride index");
            return;
        }

        Ride r = rides.get(index);

        if("COMPLETED".equals(r.status)) {
            System.out.println("Ride already completed");
            return;
        }

        r.status = "COMPLETED";
        r.driver.isAvailable = true;

        System.out.println("Ride completed. Driver released.");

    }

    // Creating a method to display the drivers
    public void viewDrivers() {
    	int INDEX = 1;
    	
        System.out.println("\nDrivers list");
        System.out.println();
        for(Driver driver : drivers) {
            System.out.println(INDEX + ". Driver ID: " + driver.driverId + "\nDriver Name: " + driver.name + "\nAvailable: " + driver.isAvailable);
            System.out.println();
            INDEX ++;
        }
    }

    // Creating a method to view ride details
    public void viewRides() {
        System.out.println("\nRide History");
        for(int i=0; i<rides.size(); i++) {
            Ride ride = rides.get(i);
            System.out.println((i+1) + " | " + ride.user.name + " -> " + ride.driver.name + " | INR " + ride.fare);
        }
    }

    // Creating amethod to delete the completed rides
    public void deleteRide(int index) {
        if(index >= 0 && index < rides.size()) {
            if (rides.get(index).status.equals("ONGOING")) {
                System.out.println("Cannot delete ongoing ride");
                return;
            }
            rides.remove(index);
            System.out.println("Ride deleted");
        } else {
            System.out.println("Invalid index");
        }
    }
}
