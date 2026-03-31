import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DigitalWalletSystem {
    
    static List<User> users = new ArrayList<>();
    static TransferService walletTransfer = new WalletTransfer();
    static TransferService bankTransfer = new BankTransfer();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nDigital Wallet System");
            System.out.println("1. Create User Wallet");
            System.out.println("2. Add Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. View Transactions");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("User ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    
                    String name;

                    while(true) {
                        System.out.print("Enter user name: ");
                        name = sc.nextLine();
                        if (!name.isEmpty() && name.matches("[a-zA-Z ]+")) {
                            break;
                        } else {
                            System.out.println("Invalid input! Name must contain letters and spaces only.");
                        }
                    }

                    users.add(new User(id, name));
                    System.out.println("Wallet created.");
                    break;

                case 2:
                    User u1 = getUser(sc);
                    if (u1 == null) break;
                    System.out.print("Amount: ");
                    u1.getWallet().addMoney(sc.nextDouble());
                    System.out.println("Money added.");
                    break;

                case 3:
                    User u2 = getUser(sc);
                    if (u2 == null) break;
                    System.out.print("Amount: ");
                    try {
                        u2.getWallet().withdraw(sc.nextDouble());
                        System.out.println("Money withdrawn.");
                    } catch (InsufficientBalanceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("From User ID: ");
                    int f = sc.nextInt();
                    System.out.print("To User ID: ");
                    int t = sc.nextInt();
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();

                    User from = findUser(f);
                    User to = findUser(t);

                    // Condition to check if both users exist
                    if (from == null || to == null) {
                        System.out.println("User not found!");
                        break;
                    }

                    // Condition to prevent transfer to self
                    if (from.getUserId() == to.getUserId()) {
                        System.out.println("Cannot transfer to the same user!");
                        break;
                    }


                    System.out.println("1. Wallet Transfer  2. Bank Transfer");
                    System.out.print("Enter transfer type: ");
                    int type = sc.nextInt();

                    try {
                        if (type == 1)
                            walletTransfer.transfer(from, to, amt);
                        else
                            bankTransfer.transfer(from, to, amt);
                        System.out.println("Transfer successful.");
                    } catch (InsufficientBalanceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    User u3 = getUser(sc);
                    if (u3 != null) {
                        u3.getWallet().showTransactions();
                        System.out.println("Balance: " + u3.getWallet().getBalance());
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using the Digital Wallet System!");
                    System.exit(0);
            }
        }
    }

    public static User findUser(int id) {
        for (User u : users)
            if (u.getUserId() == id) return u;
        return null;
    }

    public static User getUser(Scanner sc) {
        System.out.print("User ID: ");
        int id = sc.nextInt();
        User u = findUser(id);
        if (u == null) System.out.println("User not found!");
        return u;
    }
}
