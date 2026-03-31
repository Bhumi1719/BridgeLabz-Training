import java.util.*;

public class ReverseQueue {

    // Method to reverse the queue using recursion
    public static void reverseQueue(Queue<Integer> queue) {
        if(queue.isEmpty()) {
            return;
        }

        // Removing front element
        int front = queue.remove();

        // Recursively reversing remaining queue
        reverseQueue(queue);

        // Adding removed element at the end
        queue.add(front);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> queue = new LinkedList<>();

        System.out.print("Enter the number of elements in the queue: ");
        int n = sc.nextInt();

        System.out.print("Enter elements of the queue: ");
        for(int i=0; i<n; i++) {
            queue.add(sc.nextInt());
        }

        System.out.println("\nOriginal Queue is: " + queue);

        reverseQueue(queue);

        System.out.println("Reversed Queue is: " + queue);
    }
}
