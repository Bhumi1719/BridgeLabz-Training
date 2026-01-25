import java.util.Scanner;

public class VotingSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VoteManager manager = new VoteManager();

        while(true) {
            System.out.println("\n1. Cast Vote");
            System.out.println("2. Display Sorted Results");
            System.out.println("3. Display Vote Order");
            System.out.println("4. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter candidate name: ");
                    String candidate = sc.next();
                    manager.castVote(candidate);
                    System.out.println("Vote casted successfully");
                    break;

                case 2:
                    manager.displaySortedResults();
                    break;

                case 3:
                    manager.displayVoteOrder();
                    break;

                case 4:
                    System.out.println("Exited");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
