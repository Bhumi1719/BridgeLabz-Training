public class SpeedingViolation extends Violation {

    public SpeedingViolation() {
        super("Speeding");
    }

    @Override
    public double calculateFine(int previousOffenses) {
        double baseFine = 1000;
        if(previousOffenses > 1) {
            baseFine += 500;  
        }
        return baseFine;
    }
}
