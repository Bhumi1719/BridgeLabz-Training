import java.util.Scanner;

// Creating an interface named Discountable to apply discount on items
interface Discountable {
    double applyDiscount();          // Calculates discount amount
    void getDiscountDetails();        // Displays discount info
}

// Creating an abstract class named FoodItem with attributes
abstract class FoodItem {

    // Creating private attributes(Encapsulated)
    private String itemName;
    private double price;
    private int quantity;

    // Creating a constructor of the class
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Creating a getter method for item name
    public String getItemName() {
        return itemName;
    }

    // Creating a getter method for item price
    public double getPrice() {
        return price;
    }

    // Creating a getter method for item quantity
    public int getQuantity() {
        return quantity;
    }

    // Creating a concrete method to display the item details
    public void getItemDetails() {
        System.out.println("Name of the item is: " + itemName);
        System.out.println("Price of the item is: INR " + price);
        System.out.println("Quantity of the item is: " + quantity);
    }

    // Creating an abstract method to calculate the total price of the items ordered
    abstract double calculateTotalPrice();
}

// Creating a subclass named VegItem(Discountable)
class VegItem extends FoodItem implements Discountable {

	// Creating a constructor using super keyword
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    // Creating a method to calculate the total price of the veg items(no extra fee)
    @Override
    double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    // Creating a method to apply discount on the veg items(15%)
    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.15;
    }

    // Creating a method to display discount details
    @Override
    public void getDiscountDetails() {
        System.out.println("Veg Item Discount: 15%");
    }
}

// Creating a subclass named NonVegItem(Discountable)
class NonVegItem extends FoodItem implements Discountable {

    private static final double EXTRA_CHARGE = 50.0; // extra non-veg charge

    // Creating a constructor using super keyword
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    // Creating a method to calculate the total price of the nonveg items(extra fee)
    @Override
    double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + EXTRA_CHARGE;
    }

    // Creating a method to apply discount on the veg items(5%)
    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }

    // Creating a method to display discount details
    @Override
    public void getDiscountDetails() {
        System.out.println("Non-Veg Item Discount: 5%");
        System.out.println("Extra Charge Applied: INR " + EXTRA_CHARGE);
    }
}

public class FoodDelieveryApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
        FoodItem item; // Polymorphism

        System.out.println("Online Food Delivery System");
        System.out.println("1. Veg Item");
        System.out.println("2. Non-Veg Item");

        // Asking the user to enter the choice
        System.out.print("\nChoose item type: ");
        int choice = sc.nextInt();
        
        sc.nextLine(); // For clearing buffer

        // String validation
        String name;
        while(true) {
            System.out.print("Enter Item Name (alphabets only): ");
            name = sc.nextLine();

            if(name.matches("[a-zA-Z ]+")) {
                break;
            } else {
                System.out.println("Invalid input! Only alphabets allowed.");
            }
        }


        System.out.print("Enter the Price of the Item: ");
        double price = sc.nextDouble();

        System.out.print("Enter the Quantity of the Item: ");
        int quantity = sc.nextInt();

        // Switch case for object creation for different choices
        switch (choice) {
            case 1:
                item = new VegItem(name, price, quantity);
                break;
            case 2:
                item = new NonVegItem(name, price, quantity);
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        // Polymorphism + Interface Logic for order processing
        System.out.println("\n=======Order Details=======");
        item.getItemDetails();

        double total = item.calculateTotalPrice();
        System.out.println("\nTotal Price (Before Discount): INR " + total);

        if (item instanceof Discountable) {
            Discountable d = (Discountable) item;
            d.getDiscountDetails();
            double discount = d.applyDiscount();
            System.out.println("Discount Amount: INR " + discount);
            System.out.println("\nFinal Payable Amount: INR " + (total - discount));
        }

	}

}
