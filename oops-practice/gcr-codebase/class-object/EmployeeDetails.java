// Creating a class named Employee with attributes
class Employee {
	String name;
	int id;
	double salary;
	
	// Creating a constructor of the class
	Employee(String name, int id, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	
	// Creating a method to display the employee details
	void displayDetails() {
		System.out.println("Employee name is: " + name);
		System.out.println("Employee id is: " + id);
		System.out.println("Employee salary is: " + salary);
	}
}
public class EmployeeDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Creating an object of the class to call it
		Employee employee = new Employee("Rohan", 1, 500000);
		employee.displayDetails();

	}

}
