import java.util.Scanner;

public abstract class RegistrationService {
    public abstract void registerStudent(Student student, Course course);
    public abstract void dropStudentCourse(Student student, String courseName);
}

