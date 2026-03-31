import java.util.Scanner;

public class TrafficManager {
    
    static Scanner sc = new Scanner(System.in);
    static Roundabout roundabout = new Roundabout();
    static VehicleQueue queue = new VehicleQueue(5); // queue capacity

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nTraffic Manager");
            System.out.println("1. Add Vehicle to Waiting Queue");
            System.out.println("2. Move Vehicle from Queue to Roundabout");
            System.out.println("3. Remove Vehicle from Roundabout");
            System.out.println("4. Display Roundabout");
            System.out.println("5. Display Waiting Queue");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 :
                    addToQueue();
                    break;
                case 2 :
                    moveToRoundabout();
                    break;
                case 3 :
                    removeFromRoundabout();
                    break;
                case 4 :
                    roundabout.display();
                    break;
                case 5 :
                    queue.displayQueue();
                    break;
                case 6 :
                    System.out.println("Traffic system stopped");
                    return;
                default :
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void addToQueue() {
        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 

        String name;
        while(true) {
            System.out.print("Enter the vehicle name: ");
            name = sc.nextLine();

            if(!name.isEmpty() && name.matches("[a-zA-Z ]+")) {
                break;
            } else {
                System.out.println("Invalid vehicle name. Please enter only alphabets and spaces");
            }
        }

        queue.enqueue(new Vehicle(id, name));
    }

    public static void moveToRoundabout() {
        Vehicle vehicle = queue.dequeue();
        if(vehicle != null) {
            roundabout.addVehicle(vehicle);
        }
    }

    public static void removeFromRoundabout() {
        System.out.print("Enter Vehicle ID to remove: ");
        int id = sc.nextInt();
        roundabout.removeVehicle(id);
    }
}
