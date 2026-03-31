public abstract class Question {
    private int questionId;
    private String questionText;
    private int marks;

    public Question(int questionId, String questionText, int marks) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.marks = marks;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public int getMarks() {
        return marks;
    }

    public abstract boolean evaluateAnswer(String answer); // Polymorphism for Objective vs Descriptive
}
