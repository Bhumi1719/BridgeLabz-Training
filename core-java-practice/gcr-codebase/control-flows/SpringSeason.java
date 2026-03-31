import java.util.*;

public class SpringSeason {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the month ");
        int month = sc.nextInt();
        System.out.print("Enter the day ");
        int day = sc.nextInt();

        // Using if-else conditional statements to check if it is a spring season or not
        if ((month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <= 20)) {
            System.out.println("Its a Spring season"); // If the date falls within the spring season range then it will execute the If statement
        } else {
            System.out.println("Not a Spring season"); // If the date does not fall within the spring season range then it will execute the else statement
        }
    }
}