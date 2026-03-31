import java.util.*;

public class ShoppingCartManager {

    private Map<String, Double> priceMap = new HashMap<>();
    private Map<String, Integer> cartMap = new LinkedHashMap<>();

    // Method to add product price
    public void addProduct(String name, double price) {
        priceMap.put(name, price);
    }

    // Method to add item to cart
    public void addToCart(String name, int quantity) {
        if(!priceMap.containsKey(name)) {
            System.out.println("Product does not exist!");
            return;
        }
        cartMap.put(name, cartMap.getOrDefault(name, 0) + quantity);
        System.out.println("Item added to cart");
    }

    // Method to display cart in insertion order
    public void displayCart() {
        System.out.println("\nCart Items (Insertion Order):");
        for(Map.Entry<String, Integer> entry : cartMap.entrySet()) {
            String product = entry.getKey();
            int qty = entry.getValue();
            double price = priceMap.get(product);
            System.out.println(product + " | Qty: " + qty + " | Price: " + price);
        }
    }

    // Method to display items sorted by price
    public void displayCartSortedByPrice() {
        TreeMap<Double, List<String>> sortedMap = new TreeMap<>();

        for(String product : cartMap.keySet()) {
            double price = priceMap.get(product);
            sortedMap.computeIfAbsent(price, k -> new ArrayList<>()).add(product);
        }

        System.out.println("\nCart Items (Sorted by Price):");
        for(Map.Entry<Double, List<String>> entry : sortedMap.entrySet()) {
            for(String product : entry.getValue()) {
                System.out.println(product + " | Price: " + entry.getKey());
            }
        }
    }
}
