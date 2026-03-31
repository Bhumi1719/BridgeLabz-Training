// Creating a class named Student with different types of attributes
class Student {
    // Creating a static variable(shared across all)
    static String universityName = "Global University";

    // Creating a static variable to count total number of students
    static int totalStudents = 0;

    // Creating instance variables
    String name;
    String grade;

    // Creating final variable(cannot be changed once assigned)
    final int rollNumber;

    // Creating a constructor of the class
    Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber; 
        this.name = name;             
        this.grade = grade;          
        totalStudents++; // incrementing student count
    }

    // Creating a static method to display total number of students
    static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    // Creating a method to display student details using instanceof to check object type
    void displayStudentDetails(Object obj) {
        if (obj instanceof Student) { // Condition to check if obj belongs to the class Student
            Student student = (Student) obj; // Type casting

            System.out.println("University Name: " + universityName);
            System.out.println("Roll Number: " + student.rollNumber);
            System.out.println("Name: " + student.name);
            System.out.println("Grade: " + student.grade);
        }
    }

    // Creating a method to update grade using instanceof to check object type
    void updateGrade(Object obj, String newGrade) {
        if (obj instanceof Student) { // Condition to check if obj belongs to the class Student
            Student student = (Student) obj; // Type casting
            student.grade = newGrade;
            System.out.println("Grade updated to: " + student.grade);
        }
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {

        // Creating object of the class for student1
        Student student1 = new Student(101, "Hemashree", "A");

        // Creating object of the class for student2
        Student student2 = new Student(102, "Sharmila", "B");

        Student.displayTotalStudents(); // Calling the static method to display total number of students

        student1.displayStudentDetails(student1); // Calling the method to display the details of student1

        student2.displayStudentDetails(student2); // Calling the method to display the details of student2

        student2.updateGrade(student2, "A"); // Calling the method to update the grade of student2

        student2.displayStudentDetails(student2); // Calling the method to display the updated details of student2
    }
}