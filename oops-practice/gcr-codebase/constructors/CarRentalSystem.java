// Creating a class named car rental with attributes
class CarRental {
	String customerName;
    String carModel;
    int rentalDays;

    // Creating a Default constructor
    CarRental() {
        customerName = "Bhumi";
        carModel = "Thar";
        rentalDays = 2;
    }

    // Creating a Parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    // Method for calculating the total cost
    double calculateTotalCost() {
        double ratePerDay;

        if(carModel.equalsIgnoreCase("Thar")) {
            ratePerDay = 5000;
        } else if(carModel.equalsIgnoreCase("Creta")) {
            ratePerDay = 4000;
        } else if(carModel.equalsIgnoreCase("XUV 500")) {
            ratePerDay = 3000;
        } else {
            ratePerDay = 1200; 
        }

        return ratePerDay * rentalDays;
    }

    // Displaying the car rental details
    void display() {
        System.out.println("Customer Name is: " + customerName);
        System.out.println("Car Model is: " + carModel);
        System.out.println("Rental Days is: " + rentalDays);
        System.out.println("Total Cost is: INR " + calculateTotalCost()); // Calling the method to calculate the cost of the rental car
    }
}
public class CarRentalSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Making an object of the class using default constructor
		CarRental car1 = new CarRental();
		System.out.println("Details of the car using default constructor");
		car1.display();
		
		System.out.println();
		
		// Making an object of the class for parameterized constructor
        CarRental car2 = new CarRental("Abhishek", "Creta", 3);
        System.out.println("Details of the car using parameterized constructor");
        car2.display();

	}

}
