import java.util.*;

public class handshakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of students in the class:");
        int numberOfStudents = sc.nextInt();

        // Calculate the number of handshakes using the formula n(n-1)/2
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        System.out.println("The total number of handshakes among " + numberOfStudents + " students is: " + handshakes);
    }
}