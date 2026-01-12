import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private int studentId;
    private List<Course> enrolledCourses;
    private List<Character> grades;  // Store grades as A-F

    public Student(String name, int age, int studentId) {
        super(name, age);
        this.studentId = studentId;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollCourse(Course course) throws CourseLimitExceededException {
        if (enrolledCourses.size() >= 5) {
            throw new CourseLimitExceededException("Cannot enroll in more than 5 courses.");
        }
        enrolledCourses.add(course);
        System.out.println("Enrolled in course: " + course.getCourseName());
    }

    public void dropCourse(String courseName) {
        int index = -1;
        for (int i = 0; i < enrolledCourses.size(); i++) {
            if (enrolledCourses.get(i).getCourseName().equalsIgnoreCase(courseName)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            enrolledCourses.remove(index);
            if (index < grades.size()) {
                grades.remove(index);
            }
            System.out.println("Dropped course: " + courseName);
        } else {
            System.out.println("Course not found: " + courseName);
        }
    }

    public void addGrade(char grade) {
        grades.add(grade);
    }

    public void viewGrades() {
        if (grades.isEmpty()) {
            System.out.println("No grades available.");
            return;
        }
        System.out.println("Grades:");
        for (int i = 0; i < grades.size(); i++) {
            System.out.println(enrolledCourses.get(i).getCourseName() + ": " + grades.get(i));
        }
    }
}
