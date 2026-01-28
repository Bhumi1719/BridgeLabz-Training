import java.util.Scanner;

public class RestaurantReservationSystem {
        public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();

        // Pre-added tables
        restaurant.addTable(new Table(1, 4));
        restaurant.addTable(new Table(2, 2));
        restaurant.addTable(new Table(3, 6));
        restaurant.addTable(new Table(4, 2));
        restaurant.addTable(new Table(5, 6));

        while(true) {
            System.out.println("\n1. Reserve Table");
            System.out.println("2. Cancel Reservation");
            System.out.println("3. Show Available Tables");
            System.out.println("4. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch(choice) {

                case 1:
                    try {
                        System.out.print("Enter Table Number: ");
                        int tableNo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Time Slot (e.g. 7PM-8PM): ");
                        String timeSlot = sc.nextLine();

                        System.out.print("Enter Customer Name: ");
                        String name = sc.nextLine();

                        restaurant.reserveTable(tableNo, timeSlot, name);
                    } catch(TableAlreadyReservedException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter Table Number: ");
                    int tableNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Time Slot: ");
                    String timeSlot = sc.nextLine();

                    restaurant.cancelReservation(tableNo, timeSlot);
                    break;

                case 3:
                    System.out.print("Enter Time Slot: ");
                    String slot = sc.nextLine();

                    restaurant.showAvailableTables(slot);
                    break;

                case 4:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
