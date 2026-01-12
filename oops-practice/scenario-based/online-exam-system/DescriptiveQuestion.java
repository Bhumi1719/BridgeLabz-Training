public class DescriptiveQuestion extends Question {

    public DescriptiveQuestion(int questionId, String questionText, int marks) {
        super(questionId, questionText, marks);
    }

    @Override
    public boolean evaluateAnswer(String answer) {
        // For simplicity, always return true. Actual evaluation could involve teacher review.
        return true;
    }
}
