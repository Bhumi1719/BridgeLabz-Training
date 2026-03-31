abstract class CourseType {
    protected String evaluationMethod;

    public abstract void evaluate();

    public String getEvaluationMethod() {
        return evaluationMethod;
    }
}
