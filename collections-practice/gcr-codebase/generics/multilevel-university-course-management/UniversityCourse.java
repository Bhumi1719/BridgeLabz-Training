import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniversityCourse {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of courses: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<Course<? extends CourseType>> courses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("\nCourse " + (i + 1));
            System.out.print("Enter course name: ");
            String name = sc.nextLine();

            System.out.println("Select Course Type:");
            System.out.println("1. Exam-Based");
            System.out.println("2. Assignment-Based");
            System.out.println("3. Research-Based");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1) {
                courses.add(new Course<>(name, new ExamCourse()));
            } else if(choice == 2) {
                courses.add(new Course<>(name, new AssignmentCourse()));
            } else if(choice == 3) {
                courses.add(new Course<>(name, new ResearchCourse()));
            } else {
                System.out.println("Invalid choice");
            }
        }

        System.out.println("\nAll Courses Details:");
        for(Course<? extends CourseType> c : courses) {
            c.showDetails();
        }
    }
}
