import java.util.*;

// Creating a class for custom Exception
class InvalidMarkException extends Exception {
	// Creating a constructor using super keyword
	public InvalidMarkException(String msg) {
		super(msg);
	}
}

// Creating a class named student with attributes
class Student {
	String name;
	int[] marks;
	String[] subjects;

	// Creating a constructor of the class
	Student(String name, String[] subjects, int[] marks) {
		this.name = name;
		this.subjects = subjects;
		this.marks = marks;
	}
}

public class StudentReportGenerator {
	
    static Scanner sc = new Scanner(System.in);
    
    // Creating a listto store the students
    static List<Student> students = new ArrayList<>();

    // Creating a method to check valid marks are entered by user or not
    public static void validateMark(int mark) throws InvalidMarkException {
        if(mark < 0 || mark > 100) {
            throw new InvalidMarkException("Marks must be between 0 and 100");
        }
    }

    // Creating a method for calculating the average of marks
    public static double calculateAverage(int[] marks) {
        int sum = 0;
        
        for(int mark : marks) {
        	sum += mark;
        }
        return sum / (double) marks.length; // Returning the calculated average
    }

    // Creating a method to find the grade
    public static String findGrade(double avg) {
        if(avg >= 90) {
        	return "A+";
        } else if(avg >=80){
        	return "A";
        }else if(avg >= 60) {
        	return "B";
        } else if(avg >= 40) {
        	return "C";
        } else {
        	return "Fail";
        }
    }

    // Creating a method to display the report card
    public static void displayReport(Student s) {
        System.out.println("\n======REPORT CARD======");
        System.out.println("Student Name : " + s.name);
        System.out.println("-----------------------");

        for(int i=0; i<s.subjects.length; i++) {
            System.out.printf("%-15s : %3d%n", s.subjects[i], s.marks[i]);
        }

        double avg = calculateAverage(s.marks);
        System.out.println("-----------------------");
        System.out.println("Average Marks :"+ String.format("%.2f",  avg));
        System.out.println("Grade         : " + findGrade(avg));
        System.out.println("-----------------------");
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        String[] subjects = {"Maths", "Physics", "English", "Chemistry", "Hindi"};

        System.out.print("Enter the number of students: ");
        int number = sc.nextInt();
        sc.nextLine();

        for(int i=1; i<=number; i++) {
            try {
                System.out.print("\nEnter student name: ");
                String name = sc.nextLine();

                // Creating an array to store the marks
                int[] marks = new int[subjects.length];

                for(int j=0; j<subjects.length; j++) {
                    System.out.print("Enter marks for " + subjects[j] + ": ");
                    int mark = sc.nextInt();
                    
                    validateMark(mark); // Calling the method to check for valid marks
                    
                    marks[j] = mark;                    
                }
                sc.nextLine();

                students.add(new Student(name, subjects, marks)); // Adding students

            } catch (InvalidMarkException e) {
                System.out.println(e.getMessage());
                sc.nextLine(); // clear buffer
                i--; // retry same student
            }
        }

        for(Student student : students) {
            displayReport(student); // Calling the method to display the report of the students
        }
	}

}
