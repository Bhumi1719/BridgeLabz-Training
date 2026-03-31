import java.util.Scanner;

// Creating a super class named employee with attributes
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
	
    // Creating a method to display the details
	void displayDetails() {
		System.out.println();
		System.out.println("Name of the employee is: " + name);
		System.out.println("ID of the employee is: " + id);
		System.out.println("Salary of the employee is INR " + salary);
	}
}

// Creating a subclass with attributes
class Manager extends Employee {
	int teamSize;
	
    // Creating a constructor using super keyword
	Manager(String name, int id, double salary, int teamSize){
		super(name, id, salary);
		this.teamSize = teamSize;
	}
	
    // Creating a method to display the details
	void displayDetails() {
		super.displayDetails();
		System.out.println("Manager manages a team of size: " + teamSize);
		System.out.println("--------------------------------------");
	}
}

// Creating a subclass with attributes
class Developer extends Employee {
	String programmingLanguage;
	
    // Creating a constructor using super keyword
	Developer(String name, int id, double salary, String programmingLanguage) {
		super(name, id, salary);
		this.programmingLanguage = programmingLanguage;
	}
	
    // Creating a method to display the details
	void displayDetails() {
		super.displayDetails();
		System.out.println("Developer is working on langauge: " + programmingLanguage);
		System.out.println("--------------------------------------");
	}
} 

// Creting a subclass with attributes
class Intern extends Employee {
	
    // Creating a constructor using super keyword
	Intern(String name, int id, double salary) {
		super(name, id, salary);
	}
	
    // Creatin a method to display the details
	void displayDetails() {
		super.displayDetails();
	}
}
public class EmployeeHierarchy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the name of the manager: ");
		String managerName = sc.next();
		System.out.print("Enter the id of manager: ");
		int managerId = sc.nextInt();
		System.out.print("Enter the salary of manager: INR ");
		double managerSalary = sc.nextDouble();
		System.out.print("Enter the team size: ");
		int teamSize = sc.nextInt();
		
		Manager manager = new Manager(managerName, managerId, managerSalary, teamSize);
		manager.displayDetails();
		
		System.out.println();
		
		System.out.print("Enter the name of the developer: ");
		String developerName = sc.next();
		System.out.print("Enter the id of developer: ");
		int developerId = sc.nextInt();
		System.out.print("Enter the salary of developer: INR ");
		double developerSalary = sc.nextDouble();
		System.out.print("Enter the programming language: ");
		String programmingLang = sc.next();
		
        Developer developer = new Developer(developerName, developerId, developerSalary, programmingLang);
        developer.displayDetails();
        
        System.out.println();
        
        System.out.print("Enter the name of the intern: ");
		String internName = sc.next();
		System.out.print("Enter the id of intern: ");
		int internId = sc.nextInt();
		System.out.print("Enter the salary of intern: INR ");
		double internSalary = sc.nextDouble();
		
        Intern intern = new Intern(internName, internId, internSalary);
        intern.displayDetails();
	}
}
