// Making a class named cart item with attributes in it
class CartItem {
    String itemName;
    double price;
    int quantity;

    // Making a constructor of the class
    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method for adding item in the cart
    void addItem(int qty) {
        quantity += qty;
        System.out.println("Added " + qty + " of " + itemName + " to the cart.");
    }

    // Method for removing item from the cart
    void removeItem(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
            System.out.println("Removed " + qty + " of " + itemName + " from the cart.");
        } else {
            System.out.println("Cannot remove more items than available.");
        }
    }

    // Method to display the total cost of the items
    void displayTotalCost() {
        double total = price * quantity;
        System.out.println("Total cost: $" + total);
    }

    // Method to display the items in the cart
    void displayItem() {
        System.out.println("Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity);
    }
}
public class ShoppingCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Making an object of the class to call it by name
		CartItem item = new CartItem("Laptop", 999.99, 1);

        item.displayItem(); // Calling method to display the item in the cart
        item.addItem(2); // Calling the method to add item in the cart
        item.removeItem(1); // Calling the method to remove item from the cart
        item.displayTotalCost(); // Calling the method to display total cost of the items in the cart

	}

}
