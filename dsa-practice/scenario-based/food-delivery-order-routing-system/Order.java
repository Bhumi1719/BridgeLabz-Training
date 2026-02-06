public class Order {
    private int orderId;
    private String location;

    public Order(int orderId, String location) {
        this.orderId = orderId;
        this.location = location;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Order{id=" + orderId + ", location='" + location + "'}";
    }
}