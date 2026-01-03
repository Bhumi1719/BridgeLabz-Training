import java.util.Scanner;

// Creating a super class named course with attributes
class Course {
    String courseName;
    int duration; 

    // Creating a constructor of the class
    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    // Creating a method to display the details
    void displayDetails() {
        System.out.println("Course Name is: " + courseName);
        System.out.println("Duration of the course is: " + duration + " hours");
    }
}

// Creating a subclass named onlinecourse with attributes
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    // Creating a constructor using super keyword
    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    // Creating a method to display the details
    void displayDetails() {
        super.displayDetails();
        System.out.println("Platform on which course is availabel is: " + platform);
        System.out.println("Is the course recorded? " + (isRecorded ? "Yes" : "No"));
    }
}

// Creating a subclass named paidonlinecourse with attributes
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    // Creating a constructor using super keyword
    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    // Creating a method to display the details
    void displayDetails() {
        super.displayDetails();
        System.out.println("Course Fee: " + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Fee: " + (fee - (fee * discount / 100)));
    }
}

public class EducationalHierarchy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter Course Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Duration (hours): ");
        int duration = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Platform: ");
        String platform = sc.nextLine();

        System.out.print("Is Course Recorded? (true/false): ");
        boolean recorded = sc.nextBoolean();

        System.out.print("Enter Course Fee: ");
        double fee = sc.nextDouble();

        System.out.print("Enter Discount (%): ");
        double discount = sc.nextDouble();

        PaidOnlineCourse course = new PaidOnlineCourse(name, duration, platform, recorded, fee, discount);

        System.out.println("\nCourse Details");
        System.out.println();
        course.displayDetails();

	}

}
