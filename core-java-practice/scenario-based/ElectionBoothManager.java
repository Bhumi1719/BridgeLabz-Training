import java.util.*;

public class ElectionBoothManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initializing 0 votes for 1
        int vote1 = 0;
        // Initializing 0 votes for 2
        int vote2 = 0;
        // Initializing 0 votes for 3
        int vote3 = 0;

        // Running an infinite loop for multiple voters which ends when special character is entered
        while(true) {
            System.out.print("\nEnter your age or enter -1 to exit: ");
            int age = sc.nextInt(); // Age is taken user input inside the loop to take input for multiple voters

            if(age == -1) {
                System.out.println("Voting is closed"); // Edge case for loop to terminate
                break;
            }
            if(age >= 18) {
                System.out.println("Vote for 1/2/3: ");
                int vote = sc.nextInt(); // If age >= 18 then eligible for vote and give vote for any three

                // Conditionals for counting number of votes
                if(vote == 1) {
                    vote1 ++;
                } else if(vote == 2) {
                    vote2 ++;
                } else if(vote == 3) {
                    vote3 ++;
                } else {
                    System.out.println("Give proper vote");
                }
            } else {
                System.out.println("Not eligible for vote");
            }
        }

        System.out.println("\nResult of Elections are: ");
        System.out.println("Total votes given to 1 candidate: " + vote1);
        System.out.println("Total votes given to 2 candidate: " + vote2);
        System.out.println("Total votes given to 3 candidate: " + vote3);
    } 
}