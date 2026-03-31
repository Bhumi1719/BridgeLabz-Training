import java.util.Scanner;

public class NthFromEnd {

    static Node head = null;

    // Method for adding node at the end
    static void add(String data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Method for finding the Nth element from end
    public static String findNthFromEnd(int n) {
        Node fast = head;
        Node slow = head;

        for(int i=0; i<n; i++) {
            if(fast == null) {
                return "N is greater than list length";
            }

            fast = fast.next;
        }

        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.data;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int size = sc.nextInt();

        System.out.print("Enter the elements: ");
        for(int i=0; i<size; i++) {
            add(sc.next());
        }

        System.out.print("Enter the position: ");
        int position = sc.nextInt();

        System.out.println("\nNth element from the end is: " + findNthFromEnd(position));
    }
}
