import java.time.LocalDate;

public class User {
    private String name;
    private LocalDate expiryDate;
    private double subscriptionFee;
    private boolean active;

    public User(String name, LocalDate expiryDate, double subscriptionFee) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.subscriptionFee = subscriptionFee;
        this.active = true;
    }

    public String getName() { return name; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public double getSubscriptionFee() { return subscriptionFee; }
    public boolean isActive() { return active; }

    public void renew(LocalDate newDate, double newFee) {
        this.expiryDate = newDate;
        this.subscriptionFee = newFee;
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }
}
