public class SeasonalPricing implements PricingStrategy {
    private double multiplier;

    public SeasonalPricing(double multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public double calculatePrice(Room room, int days) {
        return room.getBasePrice() * days * multiplier;
    }
}
