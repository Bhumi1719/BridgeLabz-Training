import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

// Creating a super class with attributes
class Order {
    String orderId;
    LocalDate orderDate;

    // Creating a constructor of the class
    Order(String orderId, String orderDateStr) {
        this.orderId = orderId;
        this.orderDate = LocalDate.parse(orderDateStr);
    }

    // Creating a method to get current order status
    String getOrderStatus() {
        LocalDate today = LocalDate.now();
        if (today.isBefore(orderDate)) {
            return "Order Not Yet Placed";
        }
        return "Order Placed";
    }

    // Creating a method to display the order details
    void displayOrderInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Order Status: " + getOrderStatus());
    }
}

// Creating a subclass with attributes
class ShippedOrder extends Order {
    String trackingNumber;

    // Creating a constructor using super keyword
    ShippedOrder(String orderId, String orderDateStr, String trackingNumber) {
        super(orderId, orderDateStr);
        this.trackingNumber = trackingNumber;
    }

    // Creating a method to get the order of the status
    String getOrderStatus() {
        LocalDate today = LocalDate.now();
        if (today.isBefore(orderDate)) {
            return "Order Not Yet Placed";
        }
        return "Order Shipped";
    }

    // Creating a method to display the order details
    void displayOrderInfo() {
        super.displayOrderInfo();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

// Creating a subclass with attributes
class DeliveredOrder extends ShippedOrder {
    LocalDate deliveryDate;

    // Creating a constructor using super keyword
    DeliveredOrder(String orderId, String orderDateStr, String trackingNumber, String deliveryDateStr) {
        super(orderId, orderDateStr, trackingNumber);
        this.deliveryDate = LocalDate.parse(deliveryDateStr);
    }

    // Creating a method to get the status of the order
    String getOrderStatus() {
        LocalDate today = LocalDate.now();

        // Check if delivery date is before order date → invalid
        if (deliveryDate.isBefore(orderDate)) {
            return "Invalid Order Dates";
        }

        if (today.isBefore(orderDate)) {
            return "Order Not Yet Placed";
        } else if (today.isBefore(deliveryDate)) {
            return "Order Shipped";
        } else {
            return "Order Delivered";
        }
    }

    // Creating a method to display the details of the order
    void displayOrderInfo() {
        super.displayOrderInfo();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}

public class OnlineRetailManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            System.out.println("Online Retail Order Management");

            System.out.print("Enter Order ID: ");
            String orderId = sc.nextLine();

            System.out.print("Enter Order Date (YYYY-MM-DD): ");
            String orderDate = sc.nextLine();

            System.out.print("Enter Tracking Number: ");
            String trackingNumber = sc.nextLine();

            System.out.print("Enter Delivery Date (YYYY-MM-DD): ");
            String deliveryDate = sc.nextLine();

            // Create DeliveredOrder object
            DeliveredOrder order = new DeliveredOrder(orderId, orderDate, trackingNumber, deliveryDate);

            System.out.println("\n----- Order Details -----");
            order.displayOrderInfo();

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format! Please enter date as YYYY-MM-DD.");
        }
	}

}
