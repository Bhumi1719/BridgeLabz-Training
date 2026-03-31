import java.util.*;

public class GenerateBinaryNumbers {

    // Method to generate first N binary numbers
    public static List<String> generateBinaryNumbers(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1"); 

        for(int i=0; i<n; i++) {
            String current = queue.remove();
            result.add(current);

            // Appending 0 and 1 to current and then adding back to queue
            queue.add(current + "0");
            queue.add(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N binary numbers: ");
        int n = sc.nextInt();

        List<String> binaryNumbers = generateBinaryNumbers(n);

        System.out.println("First " + n + " binary numbers are: " + binaryNumbers);
    }
}
