// Making a class named movie ticket with attributes in it
class MovieTicket {
    String movieName;
    String seatNumber;
    double price;
    boolean isBooked = false;

    // MAking a method to book movie ticket
    void bookTicket(String movieName, String seatNumber, double price) {
        if (!isBooked) { // IF tickets are not booked then it will book the tickets
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.price = price;
            isBooked = true;
            
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
        } else { // If tickets are booked
            System.out.println("House full!!! sorry..... Ticket already booked");
        }
    }

    // Method for displaying the ticket
    void displayTicket() {
        if (!isBooked) { // If not booked
            System.out.println("Ticket have not booked yet....");
        } else { // If booked already
            System.out.println("Price: $" + price);
            System.out.println();
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        }
    }
}
public class MovieTicketBooking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Making an object of the class to call it by name
		MovieTicket ticket = new MovieTicket(); 

        ticket.displayTicket(); // Calling the method to display the ticket

        ticket.bookTicket("Dragon", "A10", 120.0); // Calling the method to book ticket
        ticket.bookTicket("Dragon", "A10", 120.0); // Calling the method to book ticket
        ticket.bookTicket("Dragon", "A10", 120.0); // Calling the method to book ticket

        ticket.displayTicket(); // Calling the method to display the ticket after booking

	}

}
