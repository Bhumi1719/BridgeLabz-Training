import java.util.*;

public class MovieTicketBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Infinite loop for multiple customers
        while(true) {
            System.out.print("\nEnter the type of movie you want to see (Horror/Romantic/Comedy/Action/Drama): ");
            String movie = sc.next().toLowerCase();

            int TOTAL = 0; // Variable to store the total price customer has to pay

            // Switch case for movie type
            switch(movie) {
                case "romantic" :
                    TOTAL += 180;
                    break;

                case "horror" :
                    TOTAL += 200;
                    break;

                case "comedy" :
                    TOTAL += 150;
                    break;

                case  "action" :
                    TOTAL += 220;
                    break;

                case "drama" :
                    TOTAL += 160;
                    break;

                default :
                    System.out.println("\nInvalid movie type! Enter a correct movie.");
                    continue; // Asking the same user to enter a valid movie type
            }

            System.out.print("Enter the type of seat (gold/silver): ");
            String seat = sc.next().toLowerCase();

            // Conditionals for differnet seat type
            if(seat.equals("gold")) {
                TOTAL += 250;
            } else if(seat.equals("silver")) {
                TOTAL += 200;
            } else {
                System.out.println("Enter a valid seat type");
                continue; // To enter the seat type again
            }

            System.out.print("Enter the number of tickets you want to book: ");
            int tickets = sc.nextInt();

            System.out.print("Do you want snacks (yes/no)? ");
            String snacks = sc.next().toLowerCase();

            // If customer wnats snacks
            if(snacks.equals("yes")) {
                // Taking the input for type of snack 
                System.out.print("Enter the snack you want to take(popcorn/soda/burger/combo): ");
                String snack = sc.next().toLowerCase();

                switch(snack) { // Switch case for different types of snacks
                    case "popcorn" : 
                        TOTAL += 50; 
                        break;

                    case "soda" : 
                        TOTAL += 30; 
                        break;

                    case "burger" : 
                        TOTAL += 80;
                        break;

                    case "combo" : 
                        TOTAL += 120; 
                        break;
                    default : 
                        System.out.println("Invalid snack type"); 
                        continue; // For entering snack type again
                }
            }

            TOTAL *= tickets; // Storing the total price as per tickets

            System.out.println("\nYour Total Ticket Price is INR " + TOTAL);

            // Taking user input for next customer if present
            System.out.print("\nDo you want to process next customer (yes / no)? ");
            String choice = sc.next().toLowerCase();

            // Edge case for the loop to terminate
            if(choice.equals("no")) {
                System.out.println("Thank you for using Movie Ticket Booking App!");
                break;
            }
        }
    }
}