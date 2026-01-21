public abstract class Exam {
    private String examName;

    // Creating a constructor of the class named Exam
    public Exam(String examName) {
        this.examName = examName;
    }

    // Creating getter method to get the exam name
    public String getExamName() {
        return examName;
    }

    // Creating a method for evaluation of logic
    protected abstract int evaluate();

    // Creating a method to access evaluation safely
    public int startEvaluation() {
        return evaluate();
    }
}
