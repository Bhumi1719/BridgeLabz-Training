// Creating a class named Employee with different attributes
class Employee {
    // Creating a static variable(shared by all)
    static String companyName = "Tech Solutions Inc.";

    // Creating a static variable to count total number of employees
    static int totalEmployees = 0;

    // Creating instance variables
    String name;
    String designation;

    // Creating a final variable(cannot be changed once assigned)
    final int id;

    // Constructor using 'this' keyword
    Employee(int id, String name, String designation) {
        this.id = id;                   
        this.name = name;               
        this.designation = designation; 
        totalEmployees++; // Incrementing employee count
    }

    // Creating a static method to display total number of employees
    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Creating a method using instanceof to display employee details
    void displayEmployeeDetails(Object obj) {
        if (obj instanceof Employee) { // Condition to check whether obj is an instance of class Employee
            Employee e = (Employee) obj; // Type casting

            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + e.id);
            System.out.println("Name: " + e.name);
            System.out.println("Designation: " + e.designation);
            System.out.println();
        }
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {

        // Creating an object of the class for employee1
        Employee employee1 = new Employee(101, "Thamarai", "Software Engineer");

        // Creating an object of the class for employee2
        Employee employee2 = new Employee(102, "Rohan", "Project Manager");

        Employee.displayTotalEmployees(); // Calling the static method to display the total number of employees 

        employee1.displayEmployeeDetails(employee1); // Calling the method to display the employee1 details
        employee2.displayEmployeeDetails(employee2); // Calling the method to display the employee2 details
    }
}
