import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelReservationSystem {
    
    // Creating a list of rooms
    static List<Room> rooms = new ArrayList<>();

    // Creating a list of guests
    static List<Guest> guests = new ArrayList<>();

    // Creating a list of reservations
    static List<Reservation> reservations = new ArrayList<>();
    static PricingStrategy pricing = new SeasonalPricing(2); // seasonal pricing

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        rooms.add(new StandardRoom(101));
        rooms.add(new StandardRoom(102));
        rooms.add(new StandardRoom(103));
        rooms.add(new StandardRoom(104));
        rooms.add(new StandardRoom(105));
        rooms.add(new DeluxeRoom(201));
        rooms.add(new DeluxeRoom(202));
        rooms.add(new DeluxeRoom(203));
        rooms.add(new DeluxeRoom(204));
        rooms.add(new DeluxeRoom(205));


        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. View Rooms");
            System.out.println("2. Add Guest");
            System.out.println("3. Book Room");
            System.out.println("4. Check-In");
            System.out.println("5. Check-Out");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    viewRooms();
                    break;

                case 2:
                    System.out.print("Guest ID: ");
                    int gid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String gname = sc.nextLine();
                    guests.add(new Guest(gid, gname));
                    System.out.println("Guest added.");
                    break;

                case 3:
                    try {
                        bookRoom(sc);
                    } catch (RoomNotAvailableException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Reservation ID: ");
                    int rid = sc.nextInt();
                    checkIn(rid);
                    break;

                case 5:
                    System.out.print("Reservation ID: ");
                    int cid = sc.nextInt();
                    checkOut(cid);
                    break;

                case 6:
                    System.out.println("Thank you for using our Hotel");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void viewRooms() {
        for (Room r : rooms) {
            System.out.println("Room " + r.getRoomNumber() + " | " + r.getType() + " | Price: " + r.getBasePrice() + " | Available: " + r.isAvailable());
        }
    }

    public static void bookRoom(Scanner sc) throws RoomNotAvailableException {
        System.out.print("Guest ID: ");
        int gid = sc.nextInt();

        Guest g = null;
        for (Guest x : guests) {
            if (x.getGuestId() == gid) {
                g = x;
                break;
            }
        }

        if (g == null) {
            System.out.println("Guest not found.");
            return;
        }

        System.out.print("Room Number: ");
        int rn = sc.nextInt();
        
        Room room = null;
        for (Room r : rooms) {
            if (r.getRoomNumber() == rn) {
                room = r;
                break;
            }
        }

        if (room == null || !room.isAvailable()) {
            throw new RoomNotAvailableException("Room not available!");
        }

        System.out.print("Days: ");
        int days = sc.nextInt();

        room.book();
        int resId = reservations.size() + 1;
        reservations.add(new Reservation(resId, g, room, days));
        System.out.println("Room booked \nReservation ID: " + resId);
    }

    public static void checkIn(int rid) {
        Reservation r = null;
        for (Reservation x : reservations) {
            if (x.getReservationId() == rid) {
                r = x;
                break;
            }
        }

        if (r != null) {
            System.out.println("Checked in: " + r.getGuest().getName());
        } else {
            System.out.println("Reservation not found.");
        }
    }

    public static void checkOut(int rid) {
        Reservation r = null;
        for (Reservation x : reservations) {
            if (x.getReservationId() == rid) {
                r = x;
                break;
            }
        }


        if (r == null) {
            System.out.println("Reservation not found.");
            return;
        }

        double bill = pricing.calculatePrice(r.getRoom(), r.getDays());
        r.getRoom().free();

        System.out.println("\nDetails of Room Checkout: ");
        System.out.println("Guest: " + r.getGuest().getName());
        System.out.println("Room: " + r.getRoom().getRoomNumber() + " (" + r.getRoom().getType() + ")");
        System.out.println("Days: " + r.getDays());
        System.out.println("Total: INR " + bill);
    }
}
