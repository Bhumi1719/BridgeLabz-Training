public class UPIProcessor implements PaymentProcessor {
    private String upiId;

    public UPIProcessor(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("\nPaid $" + amount + " using UPI ID: " + upiId);
    }
}