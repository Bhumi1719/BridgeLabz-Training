import java.util.*;

// Creating a class named Flight with attributes
class Flight {
    int flightId;
    String source;
    String destination;
    int seats;

    // Creating a constructor of the class
    Flight(int flightId, String source, String destination, int seats) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.seats = seats;
    }
}

// Creating a class named Booking with attributes
class Booking {
    int bookingId;
    String passengerName;
    Flight flight;

    // Creating a constructor of the class
    Booking(int bookingId, String passengerName, Flight flight) {
        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.flight = flight;
    }
}

public class FlightBookingSystem {

    // Creating an array for available flights
    public static Flight[] flights = {
        new Flight(1, "Delhi", "Mumbai", 5),
        new Flight(2, "Delhi", "Bangalore", 3),
        new Flight(3, "Mumbai", "Chennai", 4),
        new Flight(4, "Mumbai", "Delhi", 4),
        new Flight(5, "Bangalore", "Chennai", 4),
        new Flight(6, "Chennai", "West-Bengal", 4)
    };

    // Creating a list for bookings
    static List<Booking> bookings = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);
    static int BOOKING_CENTER = 1;

    public static void main(String[] args) {
        while(true) {
            System.out.println("\n1.Search Flight");
            System.out.println("2.Book Flight");
            System.out.println("3.View Bookings");
            System.out.println("Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1 :
                    searchFlight();
                    break;
                case 2 :
                    bookFlight();
                    break;
                case 3 :
                    viewBookings();
                    break;
                case 4 :
                    System.out.println("Thank You for visiting");
                    System.exit(0);
                default :
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    // Creating a method for flight search
    public static void searchFlight() {
        System.out.print("Enter source: ");
        String src = sc.next();

        System.out.print("Enter destination: ");
        String dest = sc.next();

        boolean FOUND = false;

        for(Flight flight : flights) {
            if(flight.source.equalsIgnoreCase(src) && flight.destination.equalsIgnoreCase(dest)) {

                System.out.println("Flight ID: " + flight.flightId + ", Seats Available: " + flight.seats);
                FOUND = true;
            }
        }
        if(!FOUND) {
            System.out.println("No flights found");
        }
    }

    // Creating a method to book a flight
    public static void bookFlight() {
        System.out.print("Enter Flight ID: ");
        int id = sc.nextInt();

        for(Flight flight : flights) {
            if(flight.flightId == id) {
                if(flight.seats > 0) {
                    System.out.print("Passenger Name: ");
                    String name = sc.next();

                    bookings.add(new Booking(BOOKING_CENTER ++, name, flight));
                    flight.seats --;

                    System.out.println("Booking Successful");
                } else {
                    System.out.println("No seats available");
                }
                return;
            }
        }
        System.out.println("Flight not found");
    }

    // Creating a method to display bookings
    public static void viewBookings() {
        if(bookings.isEmpty()) {
            System.out.println("No bookings found");
            return;
        }

        for(Booking book : bookings) {
            System.out.println("Booking ID: " + book.bookingId + ", Passenger: " + book.passengerName + ", Flight: " + book.flight.flightId + " (" + book.flight.source + " -> " + book.flight.destination + ")");
        }
    }
}
