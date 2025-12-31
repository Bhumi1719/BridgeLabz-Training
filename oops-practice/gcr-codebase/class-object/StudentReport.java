// Creating a class named student with attributes
class Student {
	String name;
	String rollNo;
	double marks1;
	double marks2;
	double marks3;
	
	// Making a constructor of the class
	Student(String name, String rollNo, double marks1, double marks2, double marks3) {
		this.name = name;
		this.rollNo = rollNo;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;
	}
	
	// Creating a method for calculating the grade based on the marks
	char calculateGrade() {
		double average = (marks1 + marks2 + marks3) / 3.0;
		
		if(average >= 80) {
			return 'A';
		} else if(average >= 70 && average < 80) {
			return 'B';
		} else if(average >= 60 && average < 70) {
			return 'C';
		} else if(average >= 50 && average < 60) {
			return 'D';
		} else if(average >= 40 && average < 50) {
			return 'E';
		} else {
			return 'F';
		}
	}
	
	// Creating a method to display the details and grade of student
	void displayDetails() {
		System.out.println("Student Name: " + name);
		System.out.println("Student RollNumber: " + rollNo);
		System.out.println("Student Marks:");
		System.out.println("Marks1: " + marks1);
		System.out.println("Marks2: " + marks2);
		System.out.println("Marks3: " + marks3);
		System.out.println("Grade " + calculateGrade()); // Calling the method to calculate the grade
	}
	
}
public class StudentReport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Creating an object of the class to call it by name for first student
		Student student1 = new Student("Thamarai", "ECE001", 80.0, 70.0, 75.0);
		student1.displayDetails(); // Calling the method to display the details of student 1
		
		// Creating an object the class to call it by name for second student
		Student student2 = new Student("Kannan", "CSC002", 60.0, 65.0, 50.0);
		student2.displayDetails(); // Calling the method to display the details of student 2
	}

}
