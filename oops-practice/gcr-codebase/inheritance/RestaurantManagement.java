import java.util.Scanner;

interface Worker {
    void performDuties();
}

// Creating a super class with attributes
class PersonRestaurant {
    String name;
    int id;

    // Creating a constructor of the class
    PersonRestaurant(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Creating a method to display the duties
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Creating a subclass with attributes
class Chef extends PersonRestaurant implements Worker {
    String speciality;

    // Creating a constructor using super keyword
    Chef(String name, int id, String speciality) {
        super(name, id);
        this.speciality = speciality;
    }

    // Creating a method to display the duties of the staff
    public void performDuties() {
        System.out.println("Duties: Cooking " + speciality + " dishes");
    }
}

// Creating a subclass with attributes
class Waiter extends PersonRestaurant implements Worker {
    int tablesAssigned;

    // Creating a constructor using super keyword
    Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }

    // Creating a method to display the duties of the staff
    public void performDuties() {
        System.out.println("Duties: Serving customers at " + tablesAssigned + " tables");
    }
}

public class RestaurantManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        // Chef input
        System.out.println("Enter Chef Details:");
        System.out.print("Name: ");
        String chefName = sc.nextLine();
        System.out.print("ID: ");
        int chefId = sc.nextInt();
        sc.nextLine();
        System.out.print("Speciality: ");
        String speciality = sc.nextLine();

        Chef chef = new Chef(chefName, chefId, speciality);

        // Waiter input
        System.out.println("\nEnter Waiter Details:");
        System.out.print("Name: ");
        String waiterName = sc.nextLine();
        System.out.print("ID: ");
        int waiterId = sc.nextInt();
        System.out.print("Tables Assigned: ");
        int tables = sc.nextInt();

        Waiter waiter = new Waiter(waiterName, waiterId, tables);

        // Display details
        System.out.println("\n Restaurant Staff Information");
        System.out.println();
        
        chef.displayDetails();
        chef.performDuties();
        System.out.println("--------------------");

        waiter.displayDetails();
        waiter.performDuties();
	}

}
