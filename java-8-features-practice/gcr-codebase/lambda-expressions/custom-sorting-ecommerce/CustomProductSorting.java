import java.util.*;

public class CustomProductSorting {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "SmartWatch", 15000, 4.5, 10));
        products.add(new Product(2, "Jeans", 600, 4.7, 15));
        products.add(new Product(3, "Saree", 2000, 4.2, 25));
        products.add(new Product(4, "Shirt", 5000, 4.0, 20));

        // Sorting by Price (Low to High)
        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));

        System.out.println("\nSorted by Price:");
        products.forEach(System.out::println);

        // Sorting by Rating (High to Low)
        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));

        System.out.println("\nSorted by Rating:");
        products.forEach(System.out::println);

        // Sorting by Discount (High to Low)
        products.sort((p1, p2) -> Double.compare(p2.discount, p1.discount));

        System.out.println("\nSorted by Discount:");
        products.forEach(System.out::println);
    }
}