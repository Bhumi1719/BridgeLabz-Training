public class CreditCardProcessor implements PaymentProcessor {
    private String cardNumber;

    public CreditCardProcessor(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("\nPaid $" + amount + " using Credit Card: " + cardNumber);
    }
}