public class NormalFareCalculator implements FareCalculator{
	public double calculateFare(double distance) {
        return distance * 10;
    }
}
