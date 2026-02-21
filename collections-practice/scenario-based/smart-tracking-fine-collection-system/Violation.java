abstract class Violation {
    protected String type;

    public Violation(String type) {
        this.type = type;
    }

    public abstract double calculateFine(int previousOffenses);

    public String getType() {
        return type;
    }
}
