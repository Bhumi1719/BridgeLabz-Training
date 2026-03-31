import java.util.Scanner;

public class BankingSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankManager bank = new BankManager();

        while(true) {
            System.out.println("\n1. Add Account");
            System.out.println("2. Request Withdrawal");
            System.out.println("3. Process Withdrawals");
            System.out.println("4. Display Accounts Sorted by Balance");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();
                    bank.addAccount(accNo, balance);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int acc = sc.nextInt();
                    System.out.print("Enter Withdrawal Amount: ");
                    double amount = sc.nextDouble();
                    bank.requestWithdrawal(acc, amount);
                    break;

                case 3:
                    bank.processWithdrawals();
                    break;

                case 4:
                    bank.displaySortedByBalance();
                    break;

                case 5:
                    bank.displayAllAccounts();
                    break;

                case 6:
                    System.out.println("Exited");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
