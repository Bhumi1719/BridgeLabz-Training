import java.util.Scanner;
import java.util.Stack;

public class SortStack {

    public static void sortStack(Stack<Integer> stack) {
        if(!stack.isEmpty()) {
            int top = stack.pop();
            sortStack(stack);
            insertInSortedOrder(stack, top);
        }
    }

    private static void insertInSortedOrder(Stack<Integer> stack, int value) {
        if(stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }

        int top = stack.pop();
        insertInSortedOrder(stack, value);
        stack.push(top);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        System.out.print("Enter number of elements: ");
        int number = sc.nextInt();

        System.out.println("Enter " + number + " elements:");
        for(int i=0; i<number; i++) {
            stack.push(sc.nextInt());
        }

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack (Ascending): " + stack);
    }
}
