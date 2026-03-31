import java.util.*;
import java.util.stream.*;

public class StockPriceLogger {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Stock> stocks = new ArrayList<>();

        System.out.print("Enter number of stock updates: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for(int i=0; i<n; i++) {
            System.out.println("\nEnter stock details " + (i + 1));

            System.out.print("Stock Name: ");
            String name = sc.nextLine();

            System.out.print("Stock Price: ");
            double price = sc.nextDouble();
            sc.nextLine(); 

            stocks.add(new Stock(name, price));
        }

        System.out.println("\nLive Stock Updates:");

        // USing forEach to display stocks
        stocks.stream().forEach(stock -> System.out.println(stock));

    }
}
