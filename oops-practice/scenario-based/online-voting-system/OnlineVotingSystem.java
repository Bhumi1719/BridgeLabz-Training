import java.util.Scanner;

public class OnlineVotingSystem {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ElectionService service = new ElectionServiceImplementation();

        while (true) {
            System.out.println("\nOnline Voting System");
            System.out.println("1. Register Voter");
            System.out.println("2. Add Candidate");
            System.out.println("3. Cast Vote");
            System.out.println("4. Show Results");
            System.out.println("5. Exit");
            
            System.out.print("\nEnter your choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Voter ID: ");
                    int vid = sc.nextInt();
                    sc.nextLine();
                    
                    String vName;
                    while (true) {
                        System.out.print("Enter voter name: ");
                        vName = sc.nextLine();
                        if (!vName.isEmpty() && vName.matches("[a-zA-Z ]+")) {
                            break;
                        } else {
                            System.out.println("Invalid input! Name must contain letters and spaces only.");
                        }
                    }
                    service.registerVoter(new Voter(vid, vName));
                    break;

                case 2:
                    System.out.print("Candidate ID: ");
                    int cid = sc.nextInt();
                    sc.nextLine();
                    
                    String cname;
                    while (true) {
                        System.out.print("Enter candidate name: ");
                        cname = sc.nextLine();
                        if (!cname.isEmpty() && cname.matches("[a-zA-Z ]+")) {
                            break;
                        } else {
                            System.out.println("Invalid input! Name must contain letters and spaces only.");
                        }
                    }
                    service.addCandidate(new Candidate(cid, cname));
                    break;

                case 3:
                    try {
                        System.out.print("Voter ID: ");
                        int v = sc.nextInt();
                        System.out.print("Candidate ID: ");
                        int c = sc.nextInt();
                        service.castVote(v, c);
                    } catch (DuplicateVoteException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    service.showResults();
                    break;

                case 5:
                    System.out.println("Thank you for using the Online Voting System!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
