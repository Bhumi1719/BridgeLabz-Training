import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FeedbackManager manager = new FeedbackManager();

        while(true) {

            System.out.println("\nEvent Feedback System");
            System.out.println("1. Add Rating");
            System.out.println("2. Show Average Rating");
            System.out.println("3. Show Top Rated Events");
            System.out.println("4. Report");
            System.out.println("5. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            try {
                switch(choice) {
                    case 1:
                        System.out.print("Enter Event ID: ");
                        String eventId = sc.next();

                        System.out.print("Enter Rating (1-5): ");
                        int rating = sc.nextInt();

                        manager.addRating(eventId, rating);
                        System.out.println("Rating submitted");
                        break;

                    case 2:
                        System.out.print("Enter Event ID: ");
                        String id = sc.next();

                        System.out.println("Average Rating: " + manager.calculateAverage(id));
                        break;

                    case 3:
                        manager.showTopRatedEvents();
                        break;

                    case 4:
                        manager.generateReport();
                        break;

                    case 5:
                        System.out.println("Exited");
                        System.exit(0);
                }

            } catch (InvalidRatingException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
