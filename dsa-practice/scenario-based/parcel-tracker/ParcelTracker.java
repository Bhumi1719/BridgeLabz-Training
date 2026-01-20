import java.util.Scanner;

public class ParcelTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parcel tracker = new Parcel();

        tracker.initDefault();

        while(true) {
            System.out.println("\n1.Track");
            System.out.println("2.Add Checkpoint");
            System.out.println("3.Lose Parcel");
            System.out.println("4.Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    tracker.track();
                    break;
                case 2:
                    System.out.print("Add after stage: ");
                    String after = sc.nextLine();
                    System.out.print("New stage: ");
                    String ns = sc.nextLine();
                    tracker.addCheckpoint(after, ns);
                    break;
                case 3:
                    tracker.loseParcel();
                    break;
                case 4:
                    System.out.println("Exited");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
