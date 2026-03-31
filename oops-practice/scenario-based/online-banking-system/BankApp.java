import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankServiceImplementation bank = new BankServiceImplementation();

        while (true) {
            System.out.println("\n1.Create Account\n2.Check Balance\n3.Transfer\n4.Transaction History\n5.Deposit Money\n6.Withdraw Monet\n7.Exit");
            
            System.out.print("\nEnter the choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.println("1.Savings  2.Current");
                        int type = sc.nextInt();
                        System.out.print("Enter Account Number: ");
                        int no = sc.nextInt();
                        System.out.print("Enter the name of account holder: ");
                        String name = sc.next();
                        System.out.print("Enter the balance amount: ");
                        double bal = sc.nextDouble();

                        Account acc = (type == 1) ? new SavingsAccount(no, name, bal) : new CurrentAccount(no, name, bal);
                        bank.createAccount(acc);
                        System.out.println("Account created");
                        break;

                    case 2:
                        System.out.print("Enter AccNo: ");
                        Account a = bank.findAccount(sc.nextInt());
                        System.out.println("Balance: " + a.getBalance());
                        break;

                    case 3:
                        System.out.print("Enter the account number from which amount is to be transfered: ");
                        int from = sc.nextInt();
                        System.out.print("Enter the account number to which amount is to be accepted: ");
                        int to = sc.nextInt();
                        System.out.print("Enter the amount to be transfered: ");
                        double amt = sc.nextDouble();

                        try {
                            bank.transfer(from, to, amt);
                            System.out.println("Transfer Successful");
                        } catch (InsufficientBalanceException e) {
                            System.out.println("Transfer Failed: " + e.getMessage());
                        } catch (AccountNotFoundException e) {
                            System.out.println("Transfer Failed: " + e.getMessage());
                        }
                        break;

                    case 4:
                        bank.showHistory();
                        break;

                    case 5:
                        try {
                            System.out.print("Enter Account No: ");
                            int accNo = sc.nextInt();
                            System.out.print("Enter Amount: ");
                            double amount = sc.nextDouble();

                            Account accDep = bank.findAccount(accNo);
                            accDep.deposit(amount);

                            System.out.println("Deposit Successful");
                        } catch (AccountNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 6:
                        try {
                            System.out.print("Enter Account No: ");
                            int accNo = sc.nextInt();
                            System.out.print("Enter Amount: ");
                            double amount = sc.nextDouble();

                            Account accW = bank.findAccount(accNo);
                            accW.withdraw(amount);

                            System.out.println("Withdrawal Successful");
                        } catch (InsufficientBalanceException e) {
                            System.out.println("Withdrawal Failed: " + e.getMessage());
                        } catch (AccountNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 7:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
