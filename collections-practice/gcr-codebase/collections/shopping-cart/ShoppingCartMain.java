import java.util.Scanner;

public class ShoppingCartMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ShoppingCartManager manager = new ShoppingCartManager();

        while(true) {
            System.out.println("\n1. Add Product Price");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. Display Cart (Insertion Order)");
            System.out.println("4. Display Cart (Sorted by Price)");
            System.out.println("5. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = sc.next();

                    System.out.print("Enter product price: ");
                    double price = sc.nextDouble();

                    manager.addProduct(name, price);
                    System.out.println("Product price added successfully"); 
                    break;

                case 2:
                    System.out.print("Enter product name: ");
                    String product = sc.next();

                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();

                    manager.addToCart(product, qty);
                    break;

                case 3:
                    manager.displayCart();
                    break;

                case 4:
                    manager.displayCartSortedByPrice();
                    break;

                case 5:
                    System.out.println("Exited");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
