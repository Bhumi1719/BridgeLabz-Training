import java.util.Scanner;

public class StudentCourse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RegistrationService service = new RegistrationServiceImplementation();

        // Student Name Validation
        String name;
        while (true) {
            System.out.print("Enter student name: ");
            name = sc.nextLine();
            if (!name.isEmpty() && name.matches("[a-zA-Z ]+")) {
                break;
            } else {
                System.out.println("Invalid input! Name should contain only letters and spaces.");
            }
        }

        System.out.print("Enter student age: ");
        int age = sc.nextInt();

        System.out.print("Enter student ID: ");
        int studentId = sc.nextInt();
        sc.nextLine(); // Consume newline

        Student student = new Student(name, age, studentId);

        while (true) {
            System.out.println("\n1. Enroll Course");
            System.out.println("2. Drop Course");
            System.out.println("3. View Grades");
            System.out.println("4. Add Grade");
            System.out.println("5. Exit");
            
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter course ID: ");
                    int courseId = sc.nextInt();
                    sc.nextLine();

                    // Course Name Validation
                    String courseName;
                    while (true) {
                        System.out.print("Enter course name: ");
                        courseName = sc.nextLine();
                        if(!courseName.isEmpty() && courseName.matches("[a-zA-Z ]+")) {
                            break;
                        } else {
                            System.out.println("Invalid input! Course name should contain only letters and spaces.");
                        }
                    }

                    Course course = new Course(courseId, courseName);
                    service.registerStudent(student, course);
                    break;

                case 2:
                    // Course Name Validation
                    String dropName;
                    while(true) {
                        System.out.print("Enter course name to drop: ");
                        dropName = sc.nextLine();
                        if(!dropName.isEmpty() && dropName.matches("[a-zA-Z ]+")) {
                            break;
                        } else {
                            System.out.println("Invalid input! Course name should contain only letters and spaces.");
                        }
                    }

                    service.dropStudentCourse(student, dropName);
                    break;

                case 3:
                    student.viewGrades();
                    break;

                case 4:
                    if (student.getEnrolledCourses().isEmpty()) {
                        System.out.println("Enroll in courses first!");
                        break;
                    }
                    
                    // Grade validation (A-F)
                    char gradeChar;
                    while (true) {
                        System.out.print("Enter grade (A-F) for course " +
                                student.getEnrolledCourses().get(student.getEnrolledCourses().size() - 1).getCourseName() + ": ");
                        String gradeInput = sc.nextLine().toUpperCase();
                        if (gradeInput.matches("[A-F]")) {
                            gradeChar = gradeInput.charAt(0);
                            break;
                        } else {
                            System.out.println("Invalid grade! Enter a character between A and F.");
                        }
                    }

                    student.addGrade(gradeChar);
                    break;

                case 5:
                    System.out.println("Exited");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}







