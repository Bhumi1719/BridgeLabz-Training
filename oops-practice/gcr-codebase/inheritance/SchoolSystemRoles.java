import java.util.Scanner;

// Creating a super class with attributes
class Person {
    String name;
    int age;

    // Creating a constructor of the class
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // CReating a method to display the details 
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Creating a method to display the roles
    void displayRole() {
        System.out.println("Role: Person");
    }
}

// Creating a subclass with attributes
class Teacher extends Person {
    String subject;

    // Creating a constructor using super keyword
    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    // Creating a method to display the roles
    void displayRole() {
        System.out.println("Role: Teacher");
    }

    // Creating a method to display the details
    void displayDetails() {
        super.displayDetails();
        System.out.println("Subject: " + subject);
    }
}

// Creating a subclass with attributes
class Student extends Person {
    String grade;

    // Creating a constructor using super keyword
    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    // Creating a method to display the roles
    void displayRole() {
        System.out.println("Role: Student");
    }

    // Creating a method to display the details
    void displayDetails() {
        super.displayDetails();
        System.out.println("Grade: " + grade);
    }
}

// Creating a subclass with attributes
class Staff extends Person {
    String department;

    // Creating a constructor using super keyword
    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    // Creating a method to display the roles
    void displayRole() {
        System.out.println("Role: Staff");
    }

    // Creating a method to display the details
    void displayDetails() {
        super.displayDetails();
        System.out.println("Department: " + department);
    }
}

public class SchoolSystemRoles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        // Teacher input
        System.out.println("Enter Teacher Details:");
        System.out.print("Name: ");
        String tName = sc.nextLine();
        System.out.print("Age: ");
        int tAge = sc.nextInt();
        sc.nextLine();
        System.out.print("Subject: ");
        String subject = sc.nextLine();

        Teacher teacher = new Teacher(tName, tAge, subject);

        // Student input
        System.out.println("\nEnter Student Details:");
        System.out.print("Name: ");
        String sName = sc.nextLine();
        System.out.print("Age: ");
        int sAge = sc.nextInt();
        sc.nextLine();
        System.out.print("Grade: ");
        String grade = sc.nextLine();

        Student student = new Student(sName, sAge, grade);

        // Staff input
        System.out.println("\nEnter Staff Details:");
        System.out.print("Name: ");
        String stName = sc.nextLine();
        System.out.print("Age: ");
        int stAge = sc.nextInt();
        sc.nextLine();
        System.out.print("Department: ");
        String dept = sc.nextLine();

        Staff staff = new Staff(stName, stAge, dept);

        // Display details
        System.out.println("\nSchool Members Information ");
        System.out.println();

        teacher.displayRole();
        teacher.displayDetails();
        System.out.println("--------------------");

        student.displayRole();
        student.displayDetails();
        System.out.println("--------------------");

        staff.displayRole();
        staff.displayDetails();
	}

}
