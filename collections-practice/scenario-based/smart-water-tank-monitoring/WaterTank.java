public class WaterTank {

    private int tankId;
    private double capacity;
    private double currentLevel;

    public WaterTank(int tankId, double capacity, double currentLevel) throws InvalidWaterLevelException {

        if(currentLevel > capacity) {
            throw new InvalidWaterLevelException("Current level cannot exceed capacity for Tank ID: " + tankId);
        }

        this.tankId = tankId;
        this.capacity = capacity;
        this.currentLevel = currentLevel;
    }

    public int getTankId() {
        return tankId;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getCurrentLevel() {
        return currentLevel;
    }

    public double getUsagePercentage() {
        return (currentLevel / capacity) * 100;
    }

    public void checkAlert() {
        if(getUsagePercentage() < 20) {
            System.out.println("⚠ ALERT: Tank " + tankId + " below 20% level!");
        }
    }

    @Override
    public String toString() {
        return "Tank ID: " + tankId + ", Capacity: " + capacity + ", Current Level: " + currentLevel + ", Usage %: " + String.format("%.2f", getUsagePercentage());
    }
}
