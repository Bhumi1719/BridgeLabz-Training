import java.util.Scanner;

class CircularBufferSimulation {
    private int[] buffer;
    private int size;
    private int front = 0;
    private int rear = 0;
    private int count = 0;

    CircularBufferSimulation(int size) {
        this.size = size;
        buffer = new int[size];
    }

    // Inserting element
    public void insert(int value) {
        buffer[rear] = value;
        rear = (rear + 1) % size;

        if(count == size) {
            front = (front + 1) % size;
        } else {
            count++;
        }
    }

    public void display() {
        if (count == 0) {
            System.out.println("Buffer is empty");
            return;
        }
        System.out.print("Buffer: ");
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(front + i) % size] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter buffer size: ");
        int size = sc.nextInt();

        CircularBufferSimulation cb = new CircularBufferSimulation(size);

        while(true) {
            System.out.println("\n1. Insert");
            System.out.println("2. Display");
            System.out.println("3. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = sc.nextInt();
                    cb.insert(value);
                    break;

                case 2:
                    cb.display();
                    break;

                case 3:
                    System.out.println("Exited");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
