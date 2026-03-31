import java.util.Scanner;

// Creating a class node representing one state text
class TextState {
    String content;      
    TextState prev;      
    TextState next;      

    // Creating a constructor of the class node
    TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class UndoRedoManager {
    private TextState head;      // Oldest state
    private TextState tail;      // Latest state
    private TextState current;   // Current state
    private int size = 0;
    private final int maxSize = 10; // History limit

    // Creating a method to add new state
    public void addState(String text) {
        TextState newState = new TextState(text);

        // If undo was used, remove redo history
        if(current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
            size = calculateSize();
        }

        // Add at end
        if(head == null) {
            head = tail = current = newState;
            size = 1;
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
            current = newState;
            size++;
        }

        // Enforce max size
        if(size > maxSize) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Creating a method to perform undo operation
    public void undo() {
        if(current == null || current.prev == null) {
            System.out.println("Nothing to undo");
            return;
        }
        current = current.prev;
        System.out.println("Undo successful");
    }

    // Creating a method to perform redo operation
    public void redo() {
        if(current == null || current.next == null) {
            System.out.println("Nothing to redo");
            return;
        }
        current = current.next;
        System.out.println("Redo successful");
    }

    // Creating a method to display current state
    public void displayCurrent() {
        if(current == null) {
            System.out.println("Text is empty");
        } else {
            System.out.println("Current Text: " + current.content);
        }
    }

    // Creating a hepler method to recalculate size
    private int calculateSize() {
        int count = 0;
        TextState temp = head;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class UndoRedoTextEditor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Creating an object of the class manager
        UndoRedoManager manager = new UndoRedoManager();
        int choice;

        do {
            System.out.println("\n1.Type/Add Text");
            System.out.println("2.Undo");
            System.out.println("3.Redo");
            System.out.println("4.Display Current Text");
            System.out.println("5.Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Enter text: ");
                    String text = sc.nextLine();
                    manager.addState(text);
                    System.out.println("Text added successfully");
                    break;

                case 2:
                    manager.undo();
                    break;

                case 3:
                    manager.redo();
                    break;

                case 4:
                    manager.displayCurrent();
                    break;

                case 5:
                    System.out.println("Exited");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while(choice != 5);
    }
}

