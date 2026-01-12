public class Product {
    private int productId;
    private String productName;
    private int quantity;

    public Product(int productId, String productName, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addStock(int amount) {
        this.quantity += amount;
    }

    public void reduceStock(int amount) throws OutOfStockException {
        if(amount > quantity) {
            throw new OutOfStockException("Not enough stock for product: " + productName);
        }
        this.quantity -= amount;
    }
}
