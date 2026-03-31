public interface EvaluationStrategy {
    int evaluate(Exam exam, Student student) throws ExamTimeExpiredException;
}
