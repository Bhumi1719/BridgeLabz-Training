import java.util.*;

class MyHashMap {

    static class Node {
        int key, value;
        Node next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private int SIZE = 10;
    private Node[] table = new Node[SIZE];

    private int hash(int key) {
        return key % SIZE;
    }

    // Insert or Update
    public void put(int key, int value) {
        int idx = hash(key);
        Node head = table[idx];

        Node curr = head;
        while(curr != null) {
            if(curr.key == key) {
                curr.value = value; // update
                return;
            }
            curr = curr.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = head;
        table[idx] = newNode;
    }

    // Get value
    public Integer get(int key) {
        int idx = hash(key);
        Node curr = table[idx];

        while(curr != null) {
            if(curr.key == key)
                return curr.value;
            curr = curr.next;
        }
        return null;
    }

    // Remove key
    public void remove(int key) {
        int idx = hash(key);
        Node curr = table[idx];
        Node prev = null;

        while(curr != null) {
            if(curr.key == key) {
                if(prev == null)
                    table[idx] = curr.next;
                else
                    prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    // Display
    public void display() {
        for(int i=0; i<SIZE; i++) {
            System.out.print(i + ": ");
            Node curr = table[i];
            while(curr != null) {
                System.out.print("[" + curr.key + "," + curr.value + "] -> ");
                curr = curr.next;
            }
            System.out.println("null");
        }
    }
}

public class ImplementHashMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MyHashMap map = new MyHashMap();

        while(true) {
            System.out.println("\n1.Put  \n2.Get  \n3.Remove  \n4.Display  \n5.Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter key and value: ");
                    map.put(sc.nextInt(), sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter key: ");
                    Integer val = map.get(sc.nextInt());
                    System.out.println(val == null ? "Not Found" : "Value = " + val);
                    break;
                case 3:
                    System.out.print("Enter key: ");
                    map.remove(sc.nextInt());
                    System.out.println("Removed");
                    break;
                case 4:
                    map.display();
                    break;
                case 5:
                    System.out.println("Exited");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
