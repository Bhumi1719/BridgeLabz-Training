import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class StackUsingQueue {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Push operation
    public void push(int x) {
        q2.add(x);

        // Move all elements from q1 to q2
        while(!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Pop operation
    public int pop() {
        if(q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.remove();
    }

    // Top operation
    public int top() {
        if(q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.peek();
    }

    // Method to display stack
    public void display() {
        if(q1.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Stack (top to bottom): " + q1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackUsingQueue stack = new StackUsingQueue();

        while(true) {
            System.out.println("\n1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int val = sc.nextInt();
                    stack.push(val);
                    break;

                case 2:
                    System.out.println("Popped: " + stack.pop());
                    break;

                case 3:
                    System.out.println("Top: " + stack.top());
                    break;

                case 4:
                    stack.display();
                    break;

                case 5:
                    System.out.println("Exited");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
