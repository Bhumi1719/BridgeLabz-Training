public class SignalJumpViolation extends Violation {

    public SignalJumpViolation() {
        super("Signal Jump");
    }

    @Override
    public double calculateFine(int previousOffenses) {
        double baseFine = 1500;
        if(previousOffenses > 1) {
            baseFine += 700;  
        }
        return baseFine;
    }
}
