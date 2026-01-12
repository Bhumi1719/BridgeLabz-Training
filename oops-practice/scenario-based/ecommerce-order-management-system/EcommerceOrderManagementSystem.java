import java.util.ArrayList;
import java.util.Scanner;

public class EcommerceOrderManagementSystem {    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Product> catalog = new ArrayList<>();

        System.out.print("How many products to add in catalog: ");
        int products = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<products; i++) {
            System.out.println("Enter details for Product " + (i + 1));

            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            catalog.add(new Product(id, name, price));
        }

        while(true) {
            System.out.println("\n--- Product Catalog ---");
            for (Product p : catalog) {
                p.display();
            }

            System.out.print("\nEnter Customer Name (or type exit): ");
            String customerName = sc.next();
            if(customerName.equalsIgnoreCase("exit")) {
                break;
            }

            Customer customer = new Customer(1, customerName);

            System.out.print("\nEnter Product ID to buy: ");
            int productId = sc.nextInt();
            Product selected = null;

            for(Product p : catalog) {
                if (p.getId() == productId) {
                    selected = p;
                    break;
                }
            }

            if(selected == null) {
                System.out.println("Product not found!");
                continue;
            }

            // Creating an object of Order
            Order order = new Order(selected, customer);

            System.out.println("\nChoose Payment Method:");
            System.out.println("1. Card");
            System.out.println("2. UPI");
            System.out.println("3. Wallet");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            Payment payment = null;

            switch (choice) {
                case 1:
                    payment = new CardPayment(); 
                    break;
                case 2: 
                    payment = new UPIPayment(); 
                    break;
                case 3: 
                    payment = new WalletPayment(); 
                    break;
                default:
                    System.out.println("Invalid choice!");
                    return;
            }

            order.makePayment(payment);

            System.out.println("\n1. Track Order\n2. Cancel Order");

            System.out.print("Enter your choice: ");
            int opt = sc.nextInt();

            if(opt == 1) {
                order.trackOrder();
            } else if (opt == 2) {
                order.cancelOrder();
            }
        }
        System.out.println("Thank you for using the Ecommerce Order Management System!");
    }
}
