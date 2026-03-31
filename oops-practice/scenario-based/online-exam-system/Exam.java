import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Exam {
    private int examId;
    private String examName;
    private LocalDateTime endTime;
    private List<Question> questions;
    private List<Student> enrolledStudents;

    public Exam(int examId, String examName, LocalDateTime endTime) {
        this.examId = examId;
        this.examName = examName;
        this.endTime = endTime;
        this.questions = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
    }

    public int getExamId() {
        return examId;
    }

    public String getExamName() {
        return examName;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
}
