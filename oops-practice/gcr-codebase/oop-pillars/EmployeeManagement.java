import java.util.*;

// Creating an interface department which defines department-related behavior
interface Department {
	
	// Creating a method to assign department to the employee
	void assignDepartment(String deptName);
 
	// Creating a method to give the department details
	String getDepartmentDetails();
}

// Creating an abstract class named Employee(Cannot be instantiated) with attributes
abstract class Employee implements Department {
	
	// Creating private attributes(Encapsulation)
	private int employeeId;
	private String name;
	private String department;
	
	// Creating protected attribute(subclass can access)
	protected double baseSalary;

	// Creating a constructor of the abstract class
	public Employee(int employeeId, String name, double baseSalary) {
		this.employeeId = employeeId;
		this.name = name;
		this.baseSalary = baseSalary;
	}

	// Creating a getter method for employeeId
	public int getEmployeeId() {
		return employeeId;
	}

	// Creating a setter method for employeeId
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	// Creating a getter method for employee name
	public String getName() {
		return name;
	}

	// Creating a setter method for employee name
	public void setName(String name) {
		this.name = name;
	}

	// Creating an interface method to assign department to the employee(Interface Implementation)
	public void assignDepartment(String deptName) {
		this.department = deptName;
	}

	// Creating an interface method to get the department details
	public String getDepartmentDetails() {
		return department;
	}

	// Creating an abstract method to calculate salary of the employee(Subclass implementation)
	public abstract double calculateSalary();

	// Creating a concrete method to display some common details of the employee
	public void displayDetails() {
		System.out.println("ID of the employee: " + employeeId);
		System.out.println("Name of the employee: " + name);
		System.out.println("Department of the employee: " + department);
		System.out.println("Salary of the employee: " + calculateSalary());
		System.out.println("-----------------------");
	}
}

// Creating a subclass named FullTimeEmployee
class FullTimeEmployee extends Employee {
	
	// Creating a constructor using super keyword
	public FullTimeEmployee(int id, String name, double fixedSalary) {
		super(id, name, fixedSalary);
	}	

	// Creating a method to calculate salary of emplyee
 	public double calculateSalary() {
     	return baseSalary; 
 	}
}

// Creating a subclass named PartTimeEmployeement
class PartTimeEmployee extends Employee {
	private int hoursWorked;
	private double hourlyRate;

	// Creating a constructor using super keyword
	public PartTimeEmployee(int id, String name, int hoursWorked, double hourlyRate) {
		super(id, name, 0);
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
	}

	// Creating a method to calculate salary
	public double calculateSalary() {
		return hoursWorked * hourlyRate;
	}
}

public class EmployeeManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		 
		// Creating a list of employees
	    List<Employee> employees = new ArrayList<>();

	    System.out.print("Enter the number of employees: ");
	    int empNumber = sc.nextInt();

	    for(int i=0; i<empNumber; i++) {
	        System.out.println("\n1. Full Time Employee");
	        System.out.println("2. Part Time Employee");
	         
	        // Asking the user to enter the type of employee
	        System.out.print("Choose employee type: ");
	        int choice = sc.nextInt();

	        System.out.print("Enter the Employee ID: ");
	        int id = sc.nextInt();
            sc.nextLine(); // clear buffer
	         
	        System.out.print("Enter name of the Employee: ");
	        String name = sc.nextLine();
	         
	        // Condition to check if anything else is entered by user in name field except alphabets
	        if(!name.matches("[a-zA-Z ]+")) {
	       	    System.out.println("Invalid name! Only alphabets are allowed.");
	       	    i--; // For repeating the iteration
	       	    continue;
	       	}
	        System.out.print("Enter the Department in which Employee works: ");
            String department = sc.nextLine();
	         
	        // Condition to check if anything else is entered by user in department field except alphabets
	        if (!department.matches("[a-zA-Z ]+")) {
	            System.out.println("Invalid department name! Only alphabets are allowed.");
	            i--; // For repeating the iteration
	            continue;
	        }

	        Employee employee;

            // Conditions based on the choice made by the employee
	        if(choice == 1) { // If fixed salary employee
	            System.out.print("Enter the Fixed Salary: ");
	            double salary = sc.nextDouble();

	            employee = new FullTimeEmployee(id, name, salary); // Creating employee object for fulltime

	        } else { // If part-time employee
	            System.out.print("Enter Hours Worked: ");
	            int hours = sc.nextInt();

	            System.out.print("Enter the Hourly Rate: ");
	            double rate = sc.nextDouble();

	            employee = new PartTimeEmployee(id, name, hours, rate); // Creating employee object for part-time
	        }

	        employee.assignDepartment(department); // Calling the method to assign department to the employee
	        employees.add(employee); // Calling the method to add employee to the list
	    }

	    // Calling the method inside loop to display the details of the employee(Polymorphism)
	    System.out.println("\nEmployee Details");
	    System.out.println();
	    for(Employee e : employees) {
	        e.displayDetails();
	    }
	}
}
