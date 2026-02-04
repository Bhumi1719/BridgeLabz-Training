interface PaymentProcessor {
    void pay(double amount);

    // Using default method for refund
    default void refund(double amount) {
        System.out.println("\nRefund of $" + amount + " is processed using default method.");
    }
}