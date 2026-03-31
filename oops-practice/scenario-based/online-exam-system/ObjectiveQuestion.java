public class ObjectiveQuestion extends Question {
    private String correctAnswer;

    public ObjectiveQuestion(int questionId, String questionText, int marks, String correctAnswer) {
        super(questionId, questionText, marks);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean evaluateAnswer(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}
