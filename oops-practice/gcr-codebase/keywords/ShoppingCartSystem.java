class Product {
    // Creating a static variable(shared by all)
    static double DISCOUNT = 10.0; 

    // Creating instance variables
    String productName;
    double price;
    int quantity;

    // Creating final variable(cannot be changed once assigned)
    final String productID;

    // Creating a constructor of the class
    Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;     
        this.productName = productName; 
        this.price = price;            
        this.quantity = quantity;     
    }

    // Creating static method to update the discount
    static void updateDiscount(double newDiscount) {
        DISCOUNT = newDiscount;
    }

    // Creating a method using instanceof to check object type
    void displayProductDetails(Object obj) {
        if (obj instanceof Product) { // Condition for checking if obj is an instance of class Product
            Product product = (Product) obj; // Type casting

            // Calculating the price after discount
            double priceAfterDiscount = product.price - (product.price * DISCOUNT / 100);

            System.out.println("Product ID: " + product.productID);
            System.out.println("Product Name: " + product.productName);
            System.out.println("Price: $" + product.price);
            System.out.println("Quantity: " + product.quantity);
            System.out.println("Discount: " + DISCOUNT + "%");
            System.out.println("Price after Discount: $" + priceAfterDiscount);
            System.out.println();
        }
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {

        // Creating an object of the class for product1
        Product product1 = new Product("P001", "Laptop", 1200.0, 5);

        // Creating an object of the class for product2
        Product product2 = new Product("P002", "Smartphone", 800.0, 10);

        Product.updateDiscount(10.0); // Calling the method to update the discount

        product1.displayProductDetails(product1); // Calling the method to display the product1 details
        product2.displayProductDetails(product2); // Calling the method to display the product2 details
    }
}