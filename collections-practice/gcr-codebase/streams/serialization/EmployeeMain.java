import java.util.Scanner;

public class EmployeeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();

        System.out.print("Enter file path to save/load employees: ");
        String filePath = sc.nextLine();

        while(true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Save Employees to File");
            System.out.println("3. Load Employees from File");
            System.out.println("4. Display Employees");
            System.out.println("5. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();

                    Employee emp = new Employee(id, name, dept, salary);
                    manager.addEmployee(emp);
                    System.out.println("Employee added successfully!");
                    break;

                case 2:
                    manager.saveToFile(filePath);
                    break;

                case 3:
                    manager.loadFromFile(filePath);
                    break;

                case 4:
                    manager.displayEmployees();
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
