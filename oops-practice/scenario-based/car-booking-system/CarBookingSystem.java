import java.util.*;

public class CarBookingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		// Creating an object of RideService each time any service is called
        RideService service = new RideService();

        
        int choice;

        do {
            System.out.println("\n===== CAB BOOKING SYSTEM =====");
            System.out.println("1. Add Driver");
            System.out.println("2. View Drivers");
            System.out.println("3. Book Ride");
            System.out.println("4. View Ride History");
            System.out.println("5. Complete Ride");
            System.out.println("6. Delete Ride");
            System.out.println("7. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.print("Driver ID: ");
                    int driverId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Driver Name: ");
                    String driverName = sc.nextLine();
                    service.addDriver(new Driver(driverId, driverName));
                    break;

                case 2:
                    service.viewDrivers();
                    break;

                case 3:
                    System.out.print("User ID: ");
                    int userId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("User Name: ");
                    String userName = sc.nextLine();

                    User user = new User(userId, userName);

                    System.out.print("Distance (km): ");
                    double distance = sc.nextDouble();

                    System.out.print("Pricing (1-Normal, 2-Peak): ");
                    int p = sc.nextInt();

                    FareCalculator calc =
                            (p == 2) ? new PeakFareCalculator()
                                     : new NormalFareCalculator();

                    try {
                        service.bookRide(user, distance, calc);
                    } catch (NoDriverAvailableException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    service.viewRides();
                    break;

                case 5:
                	System.out.print("Ride index to complete: ");
                    service.completeRide(sc.nextInt());
                    break;

                case 6:
                    System.out.print("Enter ride index: ");
                    int index = sc.nextInt();
                    service.deleteRide(index);
                    break;

                case 7:
                    System.out.println("Thank You for using Car Booking System");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while(choice != 7);

	}

}
