import java.util.*;
import java.util.stream.*;

public class TransformingNames {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> customers = new ArrayList<>();

        System.out.print("Enter number of customers: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for(int i=0; i<n; i++) {
            System.out.print("Enter customer name: ");
            customers.add(sc.nextLine());
        }

        List<String> transformedNames = customers.stream()
                .map(String::toUpperCase) // Converting to uppercase
                .sorted() // Sorting in alphabetical order
                .collect(Collectors.toList());

        System.out.println("\nCustomer Names (Uppercase & Sorted):");
        transformedNames.forEach(System.out::println);
    }
}
