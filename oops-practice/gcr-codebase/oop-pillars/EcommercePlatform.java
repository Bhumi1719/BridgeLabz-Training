import java.util.*;

// Creating an interface named Taxable which is implemented by products on which tax is applicable
interface Taxable {

	// Creating a method to calculate the tax amount for the product
	double calculateTax();

	// Creating a method to give the tax details
	String getTaxDetails();
}

// Creating an abstract class named Product with attributes 
abstract class Product {

	// Creating private attributes(Encapsulated)
	private int productId;
	private String name;

	// Creating a protected attribute(subclass can use it)
	protected double price;

	// Creating a constructor of the abstract class
	public Product(int productId, String name, double price) {
		this.productId = productId;
		this.name = name;
		this.price = price;
	}

	// Creating a getter method for productId
	public int getProductId() {
		return productId;
	}

	// Creating a getter method for product name
	public String getName() {
		return name;
	}

	// Creating a getter method for product price
	public double getPrice() {
		return price;
	}

	// Creating a setter method to set the price safely
	public void setPrice(double price) {
		if(price > 0) { // Only if price is greater than 0
			this.price = price;
		}
	}

	// Creating an abstract method to calculate discount on products
	public abstract double calculateDiscount();

	// Creating a concrete method to display product details
	public void displayProduct() {
		System.out.println("Product ID is: " + productId);
		System.out.println("Name of the product is: " + name);
		System.out.println("Base Price of the product is: " + String.format("%.2f", price));
	}
}

// Creating a subclass named Electronics(Taxable Product)
class Electronics extends Product implements Taxable {

	// Creating a constructor using super keyword
	public Electronics(int id, String name, double price) {
		super(id, name, price);
	}

	// Creating a method to calculate discount(5%) on product
	@Override
	public double calculateDiscount() {
		return price * 0.05;
	}

	// Creating a method to calculate tax(10%) on product
	@Override
	public double calculateTax() {
		return price * 0.10;
	}

	// Creating a method to display the tax details
	@Override
	public String getTaxDetails() {
		return "GST @10%";
	}
}

//Creating a subclass named Clothing(Taxable Product)
class Clothing extends Product implements Taxable {

	// Creating a constructor using super keyword
	public Clothing(int id, String name, double price) {
		super(id, name, price);
	}

	//Creating a method to calculate discount(20%) on product
	@Override
	public double calculateDiscount() {
		return price * 0.20;
	}

	//Creating a method to calculate tax(12%) on product
	@Override
	public double calculateTax() {
		return price * 0.12;
	}

	//Creating a method to display the tax details
	@Override
	public String getTaxDetails() {
		return "GST @12%";
	}
}

//Creating a subclass named Groceries(Non-Taxable Product)
class Groceries extends Product {

	// Creating a constructor using super keyword
	public Groceries(int id, String name, double price) {
		super(id, name, price);
	}

	//Creating a method to calculate discount(15%) on product
	@Override
	public double calculateDiscount() {
		return price * 0.15;
	}
}

public class EcommercePlatform {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		// Creating a list of products
        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int prodNumber = sc.nextInt();

        for(int i=0; i<prodNumber; i++) {

            System.out.println("\n1. Electronics");
            System.out.println("2. Clothing");
            System.out.println("3. Groceries");
            
            // Asking user to enter the type of product
            System.out.print("Choose product type: ");
            int choice = sc.nextInt();

            System.out.print("Enter the Product ID: ");
            int id = sc.nextInt();

            sc.nextLine(); // clear buffer
            System.out.print("Enter the name of the product: ");
            String name = sc.nextLine();
            
            // Condition to check if only alphabets are entered in name field
            if (!name.matches("[a-zA-Z ]+")) {
                System.out.println("Invalid name! Only alphabets are allowed.");
                i--; // repeat this iteration
                continue;
            }

            System.out.print("Enter the price of the product: ");
            double price = sc.nextDouble();

            Product p;

            // Creating objects based on choice
            if(choice == 1) {
                p = new Electronics(id, name, price); // For electronics products
            } else if (choice == 2) {
                p = new Clothing(id, name, price); // For clothing products
            } else {
                p = new Groceries(id, name, price); // For groceries product
            }

            products.add(p); // Adding the product to the list
        }

        System.out.println("\nFinal Price Details");
        System.out.println();
        
        for(Product product : products) {

            double tax = 0; // Variable for tax value

            // Condition to calculate tax only if product is taxable
            if(product instanceof Taxable) {
                tax = ((Taxable) product).calculateTax(); // Calling the method to calculate tax
            }

            double discount = product.calculateDiscount(); // Calling the method to calculate discount
            double finalPrice = product.getPrice() + tax - discount; // Calling the method to calculate the price
            product.displayProduct(); // Calling the method to display the product details
            
            System.out.println("Discount on the product is: " + String.format("%.2f", discount));
            System.out.println("Tax applied on the product is: " + String.format("%.2f", tax));
            System.out.println("Final Price of the product is: " + String.format("%.2f", finalPrice));
            System.out.println("--------------------------------------");
        }
	}
}
