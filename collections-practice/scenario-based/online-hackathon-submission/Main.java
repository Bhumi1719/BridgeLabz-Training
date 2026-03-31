import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Participant> participants = new ArrayList<>();

        System.out.print("Enter number of participants: ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<n; i++) {
            try {
                System.out.print("Enter Participant ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Is submission late? (true/false): ");
                boolean isLate = sc.nextBoolean();
                sc.nextLine();

                Participant p = new Participant(id, name, isLate);

                System.out.print("Enter number of questions attempted: ");
                int q = sc.nextInt();
                sc.nextLine();

                for(int j=0; j<q; j++) {
                    System.out.print("Enter Question ID: ");
                    int qid = sc.nextInt();

                    System.out.print("Did test cases pass? (true/false): ");
                    boolean result = sc.nextBoolean();
                    sc.nextLine();

                    p.addTestResult(qid, result);
                }

                participants.add(p);

            } catch (LateSubmissionException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        Collections.sort(participants, new Comparator<Participant>() {
            @Override
            public int compare(Participant p1, Participant p2) {
                return Integer.compare(p2.getScore(), p1.getScore());
            }
        });

        System.out.println("\nLeaderboard");
        int rank = 1;
        for(Participant p : participants) {
            System.out.println("Rank " + rank + " -> " + p);
            rank++;
        }
    }
}
