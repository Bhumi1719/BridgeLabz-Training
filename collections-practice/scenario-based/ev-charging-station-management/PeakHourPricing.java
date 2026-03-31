public class PeakHourPricing implements PricingStrategy {
    public double calculateBill(double units) {
        return units * 15;  
    }
}
