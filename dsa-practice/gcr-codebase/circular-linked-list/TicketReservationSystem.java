import java.util.Scanner;

// Creating a node class for circular linked list
class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    // Creating a constructor of the class
    TicketNode(int id, String cname, String mname, String seat, String time) {
        ticketId = id;
        customerName = cname;
        movieName = mname;
        seatNumber = seat;
        bookingTime = time;
        next = null;
    }
}

public class TicketReservationSystem {

    static TicketNode head = null;   // first node
    static TicketNode tail = null;   // last node

    // Creating a method to add ticket at the end
    public static void addTicket(int id, String cname, String mname, String seat, String time) {
        TicketNode newNode = new TicketNode(id, cname, mname, seat, time);

        if(head == null) {
            head = tail = newNode;
            newNode.next = head;   // circular link
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        System.out.println("Ticket booked successfully");
    }

    // Creating a method to remove ticket by ID
    public static void removeTicket(int id) {
        if(head == null) {
            System.out.println("No tickets to remove");
            return;
        }

        TicketNode curr = head;
        TicketNode prev = tail;

        do {
            if(curr.ticketId == id) {

                // If only one node
                if(head == tail) {
                    head = tail = null;
                }
                // If head node
                else if(curr == head) {
                    head = head.next;
                    tail.next = head;
                }
                // If tail node
                else if(curr == tail) {
                    tail = prev;
                    tail.next = head;
                }
                // Middle node
                else {
                    prev.next = curr.next;
                }

                System.out.println("Ticket removed successfully");
                return;
            }

            prev = curr;
            curr = curr.next;

        } while(curr != head);

        System.out.println("Ticket ID not found");
    }

    // Creating a method to display all the tickets
    public static void displayTickets() {
        if(head == null) {
            System.out.println("No tickets booked");
            return;
        }

        TicketNode temp = head;
        System.out.println("\nBooked Tickets \n");

        do {
            System.out.println("ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while(temp != head);
    }

    // Creating a method to search tickets
    public static void searchTicket(String key) {
        if(head == null) {
            System.out.println("No tickets available");
            return;
        }

        TicketNode temp = head;
        boolean FOUND = false;

        do {
            if(temp.customerName.equalsIgnoreCase(key) ||
                temp.movieName.equalsIgnoreCase(key)) {

                System.out.println("ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
                FOUND = true;
            }
            temp = temp.next;
        } while(temp != head);

        if(!FOUND)
            System.out.println("No matching ticket found");
    }

    // Creating a method to count total tickets
    public static void countTickets() {
        if(head == null) {
            System.out.println("Total tickets: 0");
            return;
        }

        int COUNT = 0;
        TicketNode temp = head;

        do {
            COUNT ++;
            temp = temp.next;
        } while(temp != head);

        System.out.println("Total booked tickets: " + COUNT);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n1. Book Ticket");
            System.out.println("2. Remove Ticket");
            System.out.println("3. Display Tickets");
            System.out.println("4. Search Ticket");
            System.out.println("5. Count Tickets");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Ticket ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Customer Name: ");
                    String cname = sc.nextLine();
                    System.out.print("Movie Name: ");
                    String mname = sc.nextLine();
                    System.out.print("Seat Number: ");
                    String seat = sc.nextLine();
                    System.out.print("Booking Time: ");
                    String time = sc.nextLine();
                    addTicket(id, cname, mname, seat, time);
                    break;

                case 2:
                    System.out.print("Enter Ticket ID to remove: ");
                    removeTicket(sc.nextInt());
                    break;

                case 3:
                    displayTickets();
                    break;

                case 4:
                    System.out.print("Enter Customer/Movie Name: ");
                    searchTicket(sc.nextLine());
                    break;

                case 5:
                    countTickets();
                    break;

                case 6:
                    System.out.println("Exited");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while(choice != 6);
    }
}

