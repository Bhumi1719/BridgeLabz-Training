import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.getProductName());
    }

    public Product getProductById(int productId) {
        for (Product p : products) {
            if (p.getProductId() == productId) return p;
        }
        return null;
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
            return;
        }
        System.out.println("Inventory:");
        for (Product p : products) {
            System.out.println("ID: " + p.getProductId() + ", Name: " + p.getProductName() + ", Quantity: " + p.getQuantity());
        }
    }
}
