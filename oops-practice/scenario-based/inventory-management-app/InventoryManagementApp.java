import java.util.Scanner;

public class InventoryManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();
        AlertService alertService = new AlertServiceImplementation();

        while (true) {
            System.out.println("\n1. Add Product");
            System.out.println("2. Update Stock");
            System.out.println("3. Reduce Stock");
            System.out.println("4. Display Products");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            int choice;
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine(); // Consume newline
            } else {
                System.out.println("Invalid input! Enter a number 1-5.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    // Product ID validation
                    int productId;
                    while (true) {
                        System.out.print("Enter product ID: ");
                        if (sc.hasNextInt()) {
                            productId = sc.nextInt();
                            sc.nextLine();
                            break;
                        } else {
                            System.out.println("Invalid input! Product ID must be a number.");
                            sc.nextLine();
                        }
                    }

                    // Product Name validation
                    String productName;
                    while (true) {
                        System.out.print("Enter product name: ");
                        productName = sc.nextLine();
                        if (!productName.isEmpty() && productName.matches("[a-zA-Z0-9 ]+")) {
                            break;
                        } else {
                            System.out.println("Invalid input! Name must contain letters/numbers only.");
                        }
                    }

                    // Quantity validation
                    int quantity;
                    while (true) {
                        System.out.print("Enter quantity: ");
                        if (sc.hasNextInt()) {
                            quantity = sc.nextInt();
                            sc.nextLine();
                            if (quantity >= 0) break;
                        }
                        System.out.println("Invalid input! Enter a non-negative number.");
                        sc.nextLine();
                    }

                    Product product = new Product(productId, productName, quantity);
                    inventory.addProduct(product);
                    alertService.lowStockAlert(product);
                    break;

                case 2:
                    System.out.print("Enter product ID to add stock: ");
                    int addId = sc.nextInt();
                    sc.nextLine();
                    Product addProduct = inventory.getProductById(addId);
                    if (addProduct == null) {
                        System.out.println("Product not found!");
                        break;
                    }
                    System.out.print("Enter amount to add: ");
                    int addAmount = sc.nextInt();
                    sc.nextLine();
                    addProduct.addStock(addAmount);
                    System.out.println("Stock updated. Current quantity: " + addProduct.getQuantity());
                    alertService.lowStockAlert(addProduct);
                    break;

                case 3:
                    System.out.print("Enter product ID to reduce stock: ");
                    int reduceId = sc.nextInt();
                    sc.nextLine();
                    Product reduceProduct = inventory.getProductById(reduceId);
                    if (reduceProduct == null) {
                        System.out.println("Product not found!");
                        break;
                    }
                    System.out.print("Enter amount to reduce: ");
                    int reduceAmount = sc.nextInt();
                    sc.nextLine();
                    try {
                        reduceProduct.reduceStock(reduceAmount);
                        System.out.println("Stock reduced. Current quantity: " + reduceProduct.getQuantity());
                        alertService.lowStockAlert(reduceProduct);
                    } catch (OutOfStockException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    inventory.displayProducts();
                    break;

                case 5:
                    System.out.println("Exited");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Enter 1-5.");
            }
        }
    }
}

