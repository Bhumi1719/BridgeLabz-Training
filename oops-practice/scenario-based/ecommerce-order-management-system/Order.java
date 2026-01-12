public class Order {
    private Product product;
    private Customer customer;
    private String status = "Placed";

    public Order(Product product, Customer customer) {
        this.product = product;
        this.customer = customer;
    }

    public void makePayment(Payment payment) {
        try {
            payment.pay(product.getPrice());
            System.out.println("Order successful for " + customer.getName());
        } catch (PaymentFailedException e) {
            System.out.println("Payment Failed: " + e.getMessage());
        }
    }

    public void cancelOrder() {
        status = "Cancelled";
        System.out.println("Order Cancelled.");
    }

    public void trackOrder() {
        System.out.println("Order Status: " + status);
    }
}
