import java.util.*;

public class FestivalLuckyDraw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Infinite while loop to take lucky number of multiple visitors
        while(true) {
            System.out.print("\nEnter lucky number (or -1 to exit): ");
            int number = sc.nextInt();

            if(number == -1) { // Edge case for the loop to terminate if the number enetered by the visitor is -1 then while loop will terminate
                break; 
            }

            if(number <= 0) { // If number is 0 or negative then invalid number condition
                System.out.println("Invalid number. Enter a valid number and Try again.");
                continue; // for skipping invalid number
            }

            if(number % 3 == 0 && number % 5 == 0) { // Condition for winning gift
                System.out.println("Congratulations! You win a gift");
            } else {
                System.out.println("Better luck next time");
            }
        }

        System.out.println("\nNo more visitors.");
        System.out.println("Diwali Lucky draw ended!");
    }
}
