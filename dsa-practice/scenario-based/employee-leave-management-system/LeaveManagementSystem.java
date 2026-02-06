import java.util.*;

public class LeaveManagementSystem {

    static Map<Integer, Employee> employees = new HashMap<>();
    static List<LeaveRequest> leaveRequests = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Method to add Employee
    public static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Leave Balance: ");
        int balance = sc.nextInt();

        employees.put(id, new Employee(id, name, balance));
        System.out.println("Employee Added Successfully!");
    }

    // Method to request Leave
    public static void requestLeave() {
        try {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            Employee emp = employees.get(id);

            if(emp == null) {
                System.out.println("Employee not found!");
                return;
            }

            System.out.print("Enter number of leave days: ");
            int days = sc.nextInt();

            if(days > emp.leaveBalance) {
                throw new InsufficientLeaveBalanceException("Not enough leave balance!");
            }

            leaveRequests.add(new LeaveRequest(id, days));
            System.out.println("Leave Request Submitted!");

        } catch (InsufficientLeaveBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    // Method to approve Leave
    public static void approveLeave() {
        System.out.print("Enter Employee ID to approve leave: ");
        int id = sc.nextInt();

        for(LeaveRequest lr : leaveRequests) {
            if(lr.employeeId == id && lr.status.equals("Pending")) {

                Employee emp = employees.get(id);
                emp.deductLeave(lr.days);

                lr.status = "Approved";
                System.out.println("Leave Approved!");
                return;
            }
        }
        System.out.println("No pending request found.");
    }

    // Method to reject Leave
    public static void rejectLeave() {
        System.out.print("Enter Employee ID to reject leave: ");
        int id = sc.nextInt();

        for(LeaveRequest lr : leaveRequests) {
            if(lr.employeeId == id && lr.status.equals("Pending")) {
                lr.status = "Rejected";
                System.out.println("Leave Rejected!");
                return;
            }
        }
        System.out.println("No pending request found.");
    }

    // Method to view Employees
    public static void viewEmployees() {
        for(Employee e : employees.values()) {
            System.out.println("ID: " + e.id + ", Name: " + e.name + ", Leave Balance: " + e.leaveBalance);
        }
    }

    public static void main(String[] args) {

        while(true) {
            System.out.println("\nEmployee Leave Management");
            System.out.println("1. Add Employee");
            System.out.println("2. Request Leave");
            System.out.println("3. Approve Leave");
            System.out.println("4. Reject Leave");
            System.out.println("5. View Employees");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    addEmployee();
                    break;

                case 2:
                    requestLeave();
                    break;

                case 3:
                    approveLeave();
                    break;

                case 4:
                    rejectLeave();
                    break;

                case 5:
                    viewEmployees();
                    break;

                case 6:
                    System.out.println("Exited");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}