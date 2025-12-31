// Creating a class named course with attributes
class Course {
	// Creating Instance variables
    String courseName;
    int duration;     // in months
    double fee;

    // Creating Class variable (shared by all objects)
    static String instituteName = "XYZ Institute";

    // Creating a constructor of the class
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Creating an Instance method to display the details of the course
    void displayCourseDetails() {
        System.out.println("Institute Name is: " + instituteName);
        System.out.println("Course Name is: " + courseName);
        System.out.println("Duration of the course is: " + duration + " months");
        System.out.println("Fees of the course is INR " + fee);
 
    }

    // Creating a Class method to update the name of institute
    static void updateInstituteName(String name) {
        instituteName = name;
    }
}
public class OnlineCourseManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Creating an object of the class to call it by name for course1
		Course course1 = new Course("Java Full Stack", 4, 45000);
		course1.displayCourseDetails(); // Calling the method to display the details of the course
		
		System.out.println(); // For new line
		
		// Creating an object of the class to call it by name for course2
        Course course2 = new Course("C# Full Stack", 4, 30000);
        course2.displayCourseDetails(); // Calling the method to display the details of the course

        System.out.println("-----------------------------------");
        
        // Updating institute name by calling the class method
        Course.updateInstituteName("ABC Technologies");

        course1.displayCourseDetails(); // Again calling method to display the details
        System.out.println(); // For extra line
        course2.displayCourseDetails(); // Again calling the method to display the details

	}

}
