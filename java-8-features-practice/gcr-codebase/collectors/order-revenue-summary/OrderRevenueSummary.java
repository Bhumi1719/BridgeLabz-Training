import java.util.*;
import java.util.stream.Collectors;

public class OrderRevenueSummary {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Order> orders = new ArrayList<>();

        System.out.print("Enter number of orders: ");
        int number = sc.nextInt();
        sc.nextLine(); 

        for(int i=1; i<=number; i++) {

            System.out.println("\nOrder " + i);

            System.out.print("Enter customer name: ");
            String name = sc.nextLine();

            System.out.print("Enter order amount: ");
            double amount = sc.nextDouble();
            sc.nextLine(); 

            orders.add(new Order(name, amount));
        }

        // Summing up revenue per customer
        Map<String, Double> revenueSummary = orders.stream()
                        .collect(Collectors.groupingBy(
                                Order::getCustomerName,
                                Collectors.summingDouble(Order::getAmount)
                        ));

        System.out.println("\nRevenue Per Customer");

        revenueSummary.forEach((customer, total) -> System.out.println(customer + " -> $" + total));
    }
}