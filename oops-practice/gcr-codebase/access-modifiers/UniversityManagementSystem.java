// Creating a class named student with attributes
class StudentUniversity {
    public int rollNumber; // Can be accessible from anywhere
    protected String name; // Accessible within same package or subclass
    private double cgpa; // Accessible only inside the class

    // Creating a constructor of the class
    StudentUniversity(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }

    // Getter Method for getting private CGPA
    public double getCGPA() {
        return cgpa;
    }

    // Setter method for assigning private CGPA with some value
    public void setCGPA(double cgpa) {
        this.cgpa = cgpa;
    }
}

// Creating a subclass which extends the student class
class PostgraduateStudent extends StudentUniversity {

	// Creating a constructor of subclass which is calling parent constructor using super keyword
    PostgraduateStudent(int rollNumber, String name, double cgpa) {
        super(rollNumber, name, cgpa);
    }

    // Method for displaying student details
    void displayDetails() {
        System.out.println("Roll Number of the student is: " + rollNumber); // public
        System.out.println("Name of the student is: " + name);              // protected
        System.out.println("CGPA of the student is: " + getCGPA());          // private via getter method
    }
}
public class UniversityManagementSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creating an object of subclass
        PostgraduateStudent student = new PostgraduateStudent(6, "Bhumi", 8.12);

        // Calling method to display details
        student.displayDetails();
	}

}
