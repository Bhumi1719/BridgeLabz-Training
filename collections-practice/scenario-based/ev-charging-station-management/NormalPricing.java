public class NormalPricing implements PricingStrategy {
    public double calculateBill(double units) {
        return units * 10;  
    }
}
