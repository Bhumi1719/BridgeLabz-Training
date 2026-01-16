import java.util.Scanner;

// Creating a node class representing a process in Circular Linked List
class ProcessNode {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime = 0;
    int turnAroundTime = 0;
    ProcessNode next;

    // Creating a constructor of the class
    ProcessNode(int pid, int bt, int pr) {
        this.pid = pid;
        this.burstTime = bt;
        this.remainingTime = bt;
        this.priority = pr;
        this.next = null;
    }
}

public class RoundRobinScheduling {

    static ProcessNode head = null;
    static ProcessNode tail = null;

    // Creating a method to add processes at the end
    public static void addProcess(int pid, int bt, int pr) {
        ProcessNode newNode = new ProcessNode(pid, bt, pr);

        if(head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        System.out.println("Process added");
    }

    // Creatinga method to remove process by processID
    public static void removeProcess(ProcessNode prev, ProcessNode curr) {
        if(head == tail) {
            head = tail = null;
        } else if(curr == head) {
            head = head.next;
            tail.next = head;
        } else if(curr == tail) {
            tail = prev;
            tail.next = head;
        } else {
            prev.next = curr.next;
        }
    }

    // Creating a method to display the list of processes
    public static void displayProcesses() {
        if(head == null) {
            System.out.println("No processes");
            return;
        }

        ProcessNode temp = head;
        System.out.println("Processes in Queue:");

        do {
            System.out.println("PID: " + temp.pid + " | Remaining Time: " + temp.remainingTime);
            temp = temp.next;
        } while(temp != head);
    }

    // Calling the method to perform RoundRobin Algorithm
    public static void roundRobin(int timeQuantum) {
        if(head == null) {
            return;
        }

        int time = 0;
        ProcessNode curr = head;
        ProcessNode prev = tail;
        int totalProcesses = countProcesses();

        while(head != null) {

            if(curr.remainingTime > 0) {
                int execTime = Math.min(curr.remainingTime, timeQuantum);
                curr.remainingTime -= execTime;
                time += execTime;

                // Update waiting time for other processes
                ProcessNode temp = head;
                do {
                    if(temp != curr && temp.remainingTime > 0) {
                        temp.waitingTime += execTime;
                    }
                    temp = temp.next;
                } while(temp != head);
            }

            // If process is completed
            if(curr.remainingTime == 0) {
                curr.turnAroundTime = curr.waitingTime + curr.burstTime;
                removeProcess(prev, curr);
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }

            displayProcesses();
        }

        displayAverages(totalProcesses); // Calling the method find average
    }

    // Creating a method to count the processes
    public static int countProcesses() {
        if(head == null) {
            return 0;
        }

        int count = 0;
        ProcessNode temp = head;

        do {
            count++;
            temp = temp.next;
        } while(temp != head);

        return count;
    }

    // Creating a method to display average time
    public static void displayAverages(int n) {
        ProcessNode temp = head;
        double totalWaitingTime = 0;
        double totalTurnaroundTime = 0;

        System.out.println("\nProcess Execution Completed");
        System.out.println("Average Waiting Time: " + (totalWaitingTime / n));
        System.out.println("Average Turnaround Time: " + (totalTurnaroundTime / n));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n1. Add Process");
            System.out.println("2. Start Round Robin Scheduling");
            System.out.println("3. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Process ID: ");
                    int pid = sc.nextInt();
                    System.out.print("Burst Time: ");
                    int bt = sc.nextInt();
                    System.out.print("Priority: ");
                    int pr = sc.nextInt();
                    addProcess(pid, bt, pr);
                    break;

                case 2:
                    System.out.print("Enter Time Quantum: ");
                    int tq = sc.nextInt();
                    roundRobin(tq);
                    break;

                case 3:
                    System.out.println("Exited");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while(choice != 3);
    }
}

