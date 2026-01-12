public class RegistrationServiceImplementation extends RegistrationService {

    @Override
    public void registerStudent(Student student, Course course) {
        try {
            student.enrollCourse(course);
        } catch (CourseLimitExceededException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropStudentCourse(Student student, String courseName) {
        student.dropCourse(courseName);
    }
}
