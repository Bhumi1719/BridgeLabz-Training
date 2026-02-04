import java.util.*;

public class InvoiceCreation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> transactionIds = new ArrayList<>();

        System.out.print("Enter number of transactions: ");
        int transactions = sc.nextInt();

        for(int i=0; i<transactions; i++) {
            System.out.print("Enter Transaction ID " + (i + 1) + ": ");
            transactionIds.add(sc.nextInt());
        }

        // Constructor Reference
        List<Invoice> invoices = transactionIds.stream().map(Invoice::new).toList();

        System.out.println("\nGenerated Invoices:");
        invoices.forEach(System.out::println);
    }
}