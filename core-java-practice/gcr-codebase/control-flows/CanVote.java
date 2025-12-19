import java.util.*;

public class CanVote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the age of the person ");
        int age = sc.nextInt();

        // Using if-else conditional statement to check whether the person can vote
        if(age >= 18) {
            System.out.println("The person's age is " + age + " and can vote"); // If age is 18 or older then if statement executes
        } else {
            System.out.println("The person's age is " + age + " and cannot vote"); // If age is less than 18 then else statement executes
        }
    }
}   