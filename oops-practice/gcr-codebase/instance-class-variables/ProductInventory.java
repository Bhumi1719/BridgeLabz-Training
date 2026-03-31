// Making a class named product with attributes
class Product {
	// Creating Instance variables
    String productName;
    double price;

    // Creating Class variable (shared among all)
    static int totalProducts = 0;

    // Creating a constructor of the class
    Product(String productName, double price) {
        this.productName = productName;
    	this.price = price;
    	totalProducts++; // For counting each product created
    }

    // Creating an instance method to display product details
    void displayProductDetails() {
    	System.out.println("Product Name is: " + productName);
    	System.out.println("Price of the product is: " + price);
    }

    // Creating a class method to display the total products
    static void displayTotalProducts() {
    	System.out.println("Total Products are: " + totalProducts);
    }
     
}
public class ProductInventory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Creating objects of the class to display different different products
		Product product1 = new Product("Lays", 20);
        Product product2 = new Product("Kurkure", 25);
        Product product3 = new Product("Doritos", 30);

        // Calling the instance method to display the details of the products
        product1.displayProductDetails(); 
        System.out.println(); // For extra line
        product2.displayProductDetails();
        System.out.println(); // For extra line
        product3.displayProductDetails();
        System.out.println(); // For extra line
        
        Product.displayTotalProducts(); // Calling the class method to display the count of the total products

	}

}
