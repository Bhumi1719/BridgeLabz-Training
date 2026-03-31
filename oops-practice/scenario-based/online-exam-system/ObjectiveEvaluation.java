import java.time.LocalDateTime;

public class ObjectiveEvaluation implements EvaluationStrategy {

    @Override
    public int evaluate(Exam exam, Student student) throws ExamTimeExpiredException {
        if (LocalDateTime.now().isAfter(exam.getEndTime())) {
            throw new ExamTimeExpiredException("Exam time has expired for " + student.getName());
        }

        int totalMarks = 0;
        for (Question q : exam.getQuestions()) {
            if (q instanceof ObjectiveQuestion) {
                String ans = student.getSubmittedAnswers().get(q.getQuestionId());
                if (ans != null && q.evaluateAnswer(ans)) {
                    totalMarks += q.getMarks();
                }
            }
        }
        return totalMarks;
    }
}

