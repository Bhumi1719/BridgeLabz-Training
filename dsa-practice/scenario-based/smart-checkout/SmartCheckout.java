import java.util.*;

class Customer {
    String name;
    HashMap<String, Integer> items; // item -> quantity

    Customer(String name, HashMap<String, Integer> items) {
        this.name = name;
        this.items = items;
    }
}

public class SmartCheckout {

    static Queue<Customer> queue = new LinkedList<>();
    static HashMap<String, Integer> priceMap = new HashMap<>();
    static HashMap<String, Integer> stockMap = new HashMap<>();

    public static void addItems(Scanner sc) {
        System.out.print("Enter number of products in store: ");
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            System.out.print("Enter item name: ");
            String item = sc.next();
            System.out.print("Enter price: ");
            int price = sc.nextInt();
            System.out.print("Enter stock: ");
            int stock = sc.nextInt();

            priceMap.put(item, price);
            stockMap.put(item, stock);
        }
    }

    public static void addCustomer(Scanner sc) {
        System.out.print("Enter customer name: ");
        String name = sc.next();

        System.out.print("Enter number of different items: ");
        int n = sc.nextInt();

        HashMap<String, Integer> items = new HashMap<>();
        for(int i=0; i<n; i++) {
            System.out.print("Enter item name: ");
            String item = sc.next();
            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();
            items.put(item, qty);
        }

        queue.add(new Customer(name, items));
        System.out.println("Customer added to queue.");
    }

    public static void processCustomer() {
        if(queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        Customer c = queue.poll();
        int total = 0;

        System.out.println("Billing for: " + c.name);
        for(String item : c.items.keySet()) {
            int qty = c.items.get(item);

            if(!priceMap.containsKey(item)) {
                System.out.println(item + " not available.");
                continue;
            }

            int available = stockMap.get(item);
            if(available <= 0) {
                System.out.println(item + " out of stock.");
                continue;
            }

            int sellQty = Math.min(qty, available);
            int price = priceMap.get(item);
            total += price * sellQty;
            stockMap.put(item, available - sellQty);

            System.out.println(item + " x " + sellQty + " = " + (price * sellQty));
            if(sellQty < qty) {
                System.out.println("Only " + sellQty + " available for " + item);
            }
        }

        System.out.println("Total Bill = " + total);
    }

    public static void showStock() {
        System.out.println("Current Stock:");
        for(String k : stockMap.keySet()) {
            System.out.println(k + " -> " + stockMap.get(k));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        addItems(sc);

        while (true) {
            System.out.println("\n1. Add Customer");
            System.out.println("2. Process Customer");
            System.out.println("3. Show Stock");
            System.out.println("4. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1 : 
                    addCustomer(sc); 
                    break;
                case 2 : 
                    processCustomer();
                    break;
                case 3 : 
                    showStock(); 
                    break;
                case 4 : 
                    System.out.println("Exited");
                    System.exit(0);
                default : 
                    System.out.println("Invalid choice");
            }
        }
    }
}
