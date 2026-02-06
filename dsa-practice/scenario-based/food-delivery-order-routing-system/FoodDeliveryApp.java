import java.util.*;

public class FoodDeliveryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DeliveryService service = new DeliveryService();

        while(true) {
            System.out.println("\nFood Delivery System");
            System.out.println("1. Add Agent");
            System.out.println("2. Add Order");
            System.out.println("3. Assign Order");
            System.out.println("4. Cancel Order");
            System.out.println("5. View Active Deliveries");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Agent ID: ");
                        int agentId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Agent Location: ");
                        String agentLocation = sc.nextLine();

                        service.addAgent(new Agent(agentId, agentLocation));
                        break;

                    case 2:
                        System.out.print("Enter Order ID: ");
                        int orderId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Order Location: ");
                        String orderLocation = sc.nextLine();

                        service.addOrder(new Order(orderId, orderLocation));
                        break;

                    case 3:
                        service.assignOrder();
                        break;

                    case 4:
                        System.out.print("Enter Order ID to cancel: ");
                        int cancelId = sc.nextInt();

                        service.cancelOrder(cancelId);
                        break;

                    case 5:
                        service.viewActiveDeliveries();
                        break;

                    case 6:
                        System.out.println("Exited");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (NoAgentAvailableException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}