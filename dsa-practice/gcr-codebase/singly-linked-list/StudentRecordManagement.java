import java.util.Scanner;

// Creating a Node class which represents a single student record in the linked list
class StudentNode {
    int rollNo;
    String name;
    int age;
    char grade;
    StudentNode next;

    // Creating a constructor of the node class
    StudentNode(int rollNo, String name, int age, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

// Creating a linked list class to manage the student records
class StudentLinkedList {
    private StudentNode head; // Head of the linked list

    // Creating a method to add a new student record at the beginning of the list
    public void addAtBeginning(int rollNo, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNo, name, age, grade);
        newNode.next = head; // New node points to old head 
        head = newNode; // Head node updated to new node
    }

    // Creating a method to add a new student record at the end of the list
    public void addAtEnd(int rollNo, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNo, name, age, grade);

        // If list is empty new node becomes head
        if(head == null) {
            head = newNode;
            return;
        }

        // Traversing to the last node
        StudentNode temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }

        // Adding a new node at the end
        temp.next = newNode;
    }

    // Creating a method to add a new student record at specific position (1-based index)
    public void addAtPosition(int pos, int rollNo, String name, int age, char grade) {
        if(pos <= 1 || head == null) {
            addAtBeginning(rollNo, name, age, grade);
            return;
        }

        StudentNode newNode = new StudentNode(rollNo, name, age, grade);
        StudentNode temp = head;

        for(int i=1; i<pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        // Inserting new node at desired position
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Creating a method to delete a student record by roll number
    public void deleteByRollNo(int rollNo) {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }

        // If head is to be deleted
        if(head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Student record deleted");
            return;
        }

        // Loop to search for a node to be deleted
        StudentNode temp = head;
        while(temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }

        if(temp.next == null) { // If student not found
            System.out.println("Student not found");
        } else {
            temp.next = temp.next.next; // Deleting the record by updating the list
            System.out.println("Student record deleted");
        }
    }

    // Creating a method to search a student record by roll number
    public void searchByRollNo(int rollNo) {
        StudentNode temp = head;

        // Loop for traversing the list
        while(temp != null) {
            if(temp.rollNo == rollNo) {
                System.out.println("Record Found:");
                displayNode(temp);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found"); // If student not found
    }

    // Creating a method to update the grades of student using roll number
    public void updateGrade(int rollNo, char newGrade) {
        StudentNode temp = head;

        // Loop for traversing the list to find the student
        while(temp != null) {
            if(temp.rollNo == rollNo) {
                temp.grade = newGrade;
                System.out.println("Grade updated successfully");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found"); // If student not found
    }

    // Creating a method to display the records
    public void displayAll() {
        // If list is empty
        if (head == null) {
            System.out.println("No student records available");
            return;
        }
        StudentNode temp = head;

        // Loop for traversing the list
        while (temp != null) {
            displayNode(temp);
            temp = temp.next;
        }
    }

    // Creating a helper method to display a single student record
    private void displayNode(StudentNode node) {
        System.out.println("Roll No: " + node.rollNo + ", Name: " + node.name + ", Age: " + node.age + ", Grade: " + node.grade);
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();

        int choice;
        do {
            System.out.println("\n1.Add at Beginning");
            System.out.println("2.Add at End");
            System.out.println("3.Add at Position");
            System.out.println("4.Delete by Roll No");
            System.out.println("5.Search by Roll No");
            System.out.println("6.Update Grade");
            System.out.println("7.Display All");
            System.out.println("8.Exit");

            System.out.print("\nEnter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter Grade: ");
                    char grade = sc.next().charAt(0);

                    if(choice == 1) {
                        list.addAtBeginning(roll, name, age, grade);
                        System.out.println("Student added at the beginning");
                    } else if (choice == 2) {
                        list.addAtEnd(roll, name, age, grade);
                        System.out.println("Student added at the end");
                    } else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        list.addAtPosition(pos, roll, name, age, grade);
                        System.out.println("Student added at the position " + pos);
                    }
                    break;

                case 4:
                    System.out.print("Enter Roll No to delete: ");
                    list.deleteByRollNo(sc.nextInt());
                    System.out.println("Student record deleted successfully");
                    break;

                case 5:
                    System.out.print("Enter Roll No to search: ");
                    list.searchByRollNo(sc.nextInt());
                    break;

                case 6:
                    System.out.print("Enter Roll No: ");
                    int rollNo = sc.nextInt();
                    System.out.print("Enter New Grade: ");
                    char gradeStud = sc.next().charAt(0);
                    list.updateGrade(rollNo, gradeStud);
                    System.out.println("Student Grade updated successfully");
                    break;

                case 7:
                    list.displayAll();
                    break;

                case 8:
                    System.out.println("Exiting");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while(choice != 8);
    }
}
