import java.util.Scanner;

// Creating a node class for circular linked list1
class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    // Creating a constructor of the class
    TaskNode(int id, String name, int pr, String date) {
        taskId = id;
        taskName = name;
        priority = pr;
        dueDate = date;
        next = null;
    }
}

public class TaskScheduler {

    static TaskNode head = null;   // first task
    static TaskNode tail = null;   // last task
    static TaskNode current = null; // currently active task

    // Creating a method to add task at the beginning
    public static void addAtBeginning(int id, String name, int pr, String date) {
        TaskNode newNode = new TaskNode(id, name, pr, date);

        if(head == null) {
            head = tail = current = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        System.out.println("Task added at beginning");
    }

    // Creating a method to add task at the end
    public static void addAtEnd(int id, String name, int pr, String date) {
        TaskNode newNode = new TaskNode(id, name, pr, date);

        if(head == null) {
            head = tail = current = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        System.out.println("Task added at end");
    }

    // Creating a method to add task at specific position
    public static void addAtPosition(int pos, int id, String name, int pr, String date) {
        if(pos == 1) {
            addAtBeginning(id, name, pr, date);
            return;
        }

        TaskNode temp = head;
        int COUNT = 1;

        while(COUNT < pos - 1 && temp.next != head) {
            temp = temp.next;
            COUNT ++;
        }

        TaskNode newNode = new TaskNode(id, name, pr, date);
        newNode.next = temp.next;
        temp.next = newNode;

        if(temp == tail)
            tail = newNode;

        System.out.println("Task added at position " + pos);
    }

    // Creating a method to remove a task by ID
    public static void removeTask(int id) {
        if(head == null) {
            System.out.println("No tasks to remove");
            return;
        }

        TaskNode curr = head;
        TaskNode prev = tail;

        do {
            if(curr.taskId == id) {

                // Single node
                if(head == tail) {
                    head = tail = current = null;
                }
                // Head node
                else if(curr == head) {
                    head = head.next;
                    tail.next = head;
                }
                // Tail node
                else if(curr == tail) {
                    tail = prev;
                    tail.next = head;
                }
                // Middle node
                else {
                    prev.next = curr.next;
                }

                if(current == curr)
                    current = curr.next;

                System.out.println("Task removed");
                return;
            }

            prev = curr;
            curr = curr.next;

        } while(curr != head);

        System.out.println("Task ID not found");
    }

    // Creating a method to view task and move to next
    public static void viewCurrentTask() {
        if(current == null) {
            System.out.println("No tasks available");
            return;
        }

        System.out.println("Current Task -> ID: " + current.taskId + ", Name: " + current.taskName + ", Priority: " + current.priority + ", Due: " + current.dueDate);
        current = current.next; // move to next task
    }

    // Creating a method to display all tasks
    public static void displayTasks() {
        if(head == null) {
            System.out.println("No tasks available");
            return;
        }

        TaskNode temp = head;
        System.out.println("\nTask List \n");

        do {
            System.out.println( "ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while(temp != head);
    }

    // Creating a method to search process by priority
    public static void searchByPriority(int pr) {
        if(head == null) {
            System.out.println("No tasks available");
            return;
        }

        TaskNode temp = head;
        boolean FOUND = false;

        do {
            if(temp.priority == pr) {
                System.out.println( "ID: " + temp.taskId + ", Name: " + temp.taskName + ", Due Date: " + temp.dueDate);
                FOUND = true;
            }
            temp = temp.next;
        } while(temp != head);

        if(!FOUND)
            System.out.println("No task found with given priority");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task");
            System.out.println("5. View Current Task (Next)");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search by Priority");
            System.out.println("8. Exit");

            System.out.print("\nEnter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Priority: ");
                    int pr = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Due Date: ");
                    String date = sc.nextLine();

                    if (choice == 1)
                        addAtBeginning(id, name, pr, date);
                    else if (choice == 2)
                        addAtEnd(id, name, pr, date);
                    else {
                        System.out.print("Position: ");
                        int pos = sc.nextInt();
                        addAtPosition(pos, id, name, pr, date);
                    }
                    break;

                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    removeTask(sc.nextInt());
                    break;

                case 5:
                    viewCurrentTask();
                    break;

                case 6:
                    displayTasks();
                    break;

                case 7:
                    System.out.print("Enter Priority: ");
                    searchByPriority(sc.nextInt());
                    break;

                case 8:
                    System.out.println("Exited");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while(choice != 8);
    }
}
