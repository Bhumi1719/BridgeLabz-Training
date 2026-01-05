import java.util.*;

public class CafeteriaMenuApp {

	// Creating a method to display the menu items
	public static void displayMenu(String[] menu) {
		System.out.println("\n--- Cafeteria Menu ---");
		for(int i=0; i<menu.length; i++) {
			System.out.println(i + " -> " + menu[i]);
		}
	}

	// Creating a method to get menu item by index
	public static String getItemByIndex(String[] menu, int index) {

		// Condition to check for valid index
		if(index >= 0 && index < menu.length) {
			return menu[index];
		} else {
			return "Invalid item selection";
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);

        // Fixed menu items (10 items)
        String[] menu = {
            "Hot Coffee",
            "Cold Coffee",
            "Tea",
            "Plain Sandwich",
            "Aloo Tikki Burger",
            "Veg Burger",
            "White-Sauce Pasta",
            "Red-Sauce Pasta",
            "Aloo Patties",
            "Masala Patties"
        };

        // Calling the method to display the menu
        displayMenu(menu);

        // Asking customer to enter the number of items they want to order
        System.out.print("\nEnter total number of items you want to order: ");
        int totalItems = sc.nextInt();

        // Creating an array to store ordered items
        String[] orderedItems = new String[totalItems];

        // Loop for taking index of the items 
        for(int i=0; i<totalItems; i++) {

            System.out.print("Enter index for item " + (i + 1) + ": ");
            int index = sc.nextInt();

            orderedItems[i] = getItemByIndex(menu, index); // Calling the method to get item by index
        }

        // Loop for printing ordered items
        System.out.println("\nYour Order");
        for(int i=0; i<orderedItems.length; i++) {
            System.out.println((i + 1) + ". " + orderedItems[i]);
        }
	}

}
