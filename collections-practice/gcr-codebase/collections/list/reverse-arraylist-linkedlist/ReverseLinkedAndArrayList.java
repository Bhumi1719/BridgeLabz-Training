import java.util.*;

public class ReverseLinkedAndArrayList {

    // Method to reverse ArrayList
    public static void reverseArrayList(ArrayList<Integer> list) {
        int left = 0;
        int right = list.size() - 1;

        while(left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }
    }

    static Node head = null;

    // Method for adding node at the end
    public static void addNode(int data) {
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

    // Method to reverse linked list using node pointers
    public static void reverseLinkedList() {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while(curr != null) {
            next = curr.next;   // store next
            curr.next = prev;   // reverse link
            prev = curr;        // move prev
            curr = next;        // move curr
        }

        head = prev;
    }

    // Method to display linked list
    public static String getLinkedListAsString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node temp = head;

        while(temp != null) {
            sb.append(temp.data);
            if(temp.next != null) {
                sb.append(", ");
            }
            temp = temp.next;
        }

        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int size = sc.nextInt();

        ArrayList<Integer> arrayList = new ArrayList<>();

        System.out.print("Enter the elements: ");
        for(int i=0; i<size; i++) {
            int val = sc.nextInt();
            arrayList.add(val);
            addNode(val);
        }

        reverseArrayList(arrayList);
        reverseLinkedList();

        System.out.println("\nReversed ArrayList is: " + arrayList);

        System.out.print("Reversed LinkedList is: " + getLinkedListAsString());
    }
}
