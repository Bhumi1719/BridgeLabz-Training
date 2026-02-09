import java.util.Scanner;

public class AuctionMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AuctionItem item = new AuctionItem("iPhone 15");

        while(true) {

            System.out.println("\nOnline Auction");
            System.out.println("1. Place Bid");
            System.out.println("2. Show Highest Bid");
            System.out.println("3. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.print("Enter User ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Bid Amount: ");
                    double amount = sc.nextDouble();

                    User user = new User(id, name);
                    Bid bid = new Bid(user, amount);

                    try {
                        item.placeBid(bid);
                    } catch (InvalidBidException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 2:
                    item.showHighestBid();
                    break;

                case 3:
                    System.out.println("Exited");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

