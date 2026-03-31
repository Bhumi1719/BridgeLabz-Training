public class AlertServiceImplementation implements AlertService {

    @Override
    public void lowStockAlert(Product product) {
        if (product.getQuantity() < 5) { // Threshold for low stock
            System.out.println("ALERT: Low stock for product: " + product.getProductName() + " (Quantity: " + product.getQuantity() + ")");
        }
    }
}

