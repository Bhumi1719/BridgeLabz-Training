import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class SubscriptionManager {

    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void autoRenew(DiscountStrategy strategy) throws PaymentDeclinedException {

        for(User user : users) {

            if(user.getExpiryDate().isBefore(LocalDate.now())) {

                double newFee = strategy.applyDiscount(user.getSubscriptionFee());

                if(newFee <= 0) {
                    throw new PaymentDeclinedException("Payment failed for " + user.getName());
                }

                user.renew(LocalDate.now().plusMonths(1), newFee);

                System.out.println(user.getName() + " renewed successfully. New Fee: " + newFee);
            }
        }
    }

    public void showExpiredUsers() {
        List<User> expired = users.stream()
                .filter(u -> u.getExpiryDate().isBefore(LocalDate.now()))
                .collect(Collectors.toList());

        expired.forEach(u -> System.out.println("Expired: " + u.getName()));
    }
}
