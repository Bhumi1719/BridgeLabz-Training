import java.util.*;

class QueueUsingStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Enqueue operation
    void enqueue(int x) {
        stack1.push(x);
        System.out.println(x + " enqueued");
    }

    // Dequeue operation
    int dequeue() {
        if(stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Peek operation
    int peek() {
        if(stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Display queue
    void display() {
        if(stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        // stack2 has front elements
        for(int i=stack2.size() - 1; i>=0; i--) {
            System.out.print(stack2.get(i) + " ");
        }
        // stack1 has rear elements
        for(int i=0; i<stack1.size(); i++) {
            System.out.print(stack1.get(i) + " ");
        }
        System.out.println();
    }
}

public class ImplementQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueUsingStacks q = new QueueUsingStacks();

        while(true) {
            System.out.println("\n1. Enqueue\n2. Dequeue\n3. Peek\n4. Display\n5. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter element: ");
                    int x = sc.nextInt();
                    q.enqueue(x);
                    break;
                case 2:
                    int val = q.dequeue();
                    if(val != -1)
                        System.out.println("Dequeued: " + val);
                    break;
                case 3:
                    int p = q.peek();
                    if(p != -1)
                        System.out.println("Front: " + p);
                    break;
                case 4:
                    q.display();
                    break;
                case 5:
                    System.out.println("Exited");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
