// Creating a class named employee with attributes
class EmployeeModifiers {
    public int employeeID; // Accessible from anywhere

    protected String department; // Accessible within same package or subclass

    // Private variable: accessible only inside this class
    private double salary; //  // Accessible only inside this class
  

    // Creating a constructor of the subclass
    EmployeeModifiers(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to modify private salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Public method to access private salary
    public double getSalary() {
        return salary;
    }
}

// Creating a child class which extend the parent class
class Manager extends EmployeeModifiers {

    // Creating a constructor of child class which is calling parent class constructor using super keyword
    Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    // Creating a method for displaying the manager details
    void displayManagerDetails() {
        System.out.println("Employee ID is: " + employeeID);   // public access
        System.out.println("Department of the employee is: " + department);    // protected access
        System.out.println("Salary of the employee is: ₹" + getSalary());      // private via getter method
    }
}

public class EmployeeRecords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creating object of Manager class
        Manager manager = new Manager(100, "IT", 75000.0);

        manager.displayManagerDetails(); // Calling the method to display the details

        System.out.println("------------------------------------"); // for new line
        
        manager.setSalary(85000.0);

        manager.displayManagerDetails(); // Calling the method to display the details after setting the salary
	}

}
