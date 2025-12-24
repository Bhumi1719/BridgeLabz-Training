import java.util.*;

public class HandShakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = sc.nextInt();

        // Calling the function only as we have taken return type void and printed the result in the method itself
        handShakes(numberOfStudents);
    }

    // Method for finding the number of handshakes with return type void
    public static void handShakes(int students) {
        int handshakes = (students * (students - 1)) / 2; // Calculating the number of handshakes
        System.out.println("The possible number of handshakes between " + students + " students are: " + handshakes); // Directly printing inside the method
    }
}