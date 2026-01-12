public class UPIPayment implements Payment {
    public void pay(double amount) throws PaymentFailedException {
        if (amount <= 0)
            throw new PaymentFailedException("Invalid UPI amount!");
        System.out.println("Paid INR " + amount + " using UPI.");
    }
}

