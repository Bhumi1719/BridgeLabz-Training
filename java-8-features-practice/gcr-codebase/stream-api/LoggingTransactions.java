import java.time.LocalDateTime;
import java.util.*;

public class LoggingTransactions {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> transactionIds = new ArrayList<>();

        System.out.print("Enter number of transactions: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for(int i=0; i<n; i++) {
            System.out.print("Enter transaction ID: ");
            transactionIds.add(sc.nextLine());
        }

        System.out.println("\nTransaction Logs:");

        // USing forEach with timestamp
        transactionIds.forEach(id -> System.out.println(LocalDateTime.now() + " - Transaction: " + id));
    }
}
