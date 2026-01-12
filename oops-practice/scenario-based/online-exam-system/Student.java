import java.util.HashMap;
import java.util.Map;

public class Student {
    private int studentId;
    private String name;
    private Map<Integer, String> submittedAnswers; 

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.submittedAnswers = new HashMap<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void submitAnswer(int questionId, String answer) {
        submittedAnswers.put(questionId, answer);
    }

    public Map<Integer, String> getSubmittedAnswers() {
        return submittedAnswers;
    }
}
