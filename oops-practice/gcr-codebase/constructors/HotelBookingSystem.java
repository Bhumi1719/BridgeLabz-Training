// Making a class named hotel booking with attributes
class HotelBooking {
	String guestName;
    String roomType;
    int nights;

    // Making a Default constructor
    HotelBooking() {
        this.guestName = "Guest";
        this.roomType = "Standard";
        this.nights = 1;
    }

    // Making a Parameterized constructor
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Making a Copy constructor
    HotelBooking(HotelBooking booking) {
        this.guestName = booking.guestName;
        this.roomType = booking.roomType;
        this.nights = booking.nights;
    }

    // Method for displaying the copied content
    void displayDetails() {
        System.out.println("Guest Name is: " + guestName);
        System.out.println("Room Type is: " + roomType);
        System.out.println("Nights stayed are : " + nights);
  
    }
}
public class HotelBookingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Making an object of the class for default constructor
		HotelBooking hotel1 = new HotelBooking();
		System.out.println("Details of hotel booked using default constructor");
		hotel1.displayDetails();

		System.out.println();
		
		// Making an object of the class for parameterized constructor
		HotelBooking hotel2 = new HotelBooking("Bhumika", "Regular", 4);
		System.out.println("Details of hotel booked using parameterized constructor");
		hotel2.displayDetails();
		
		System.out.println();
		
		// Making an object of the class to copy the content of hotel2
		HotelBooking hotel3 = new HotelBooking(hotel2);
		System.out.println("Details of hotel booked using copy constructor");
		hotel3.displayDetails();
	}

}
