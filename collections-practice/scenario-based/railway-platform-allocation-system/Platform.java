public class Platform {
    private int platformNumber;
    private boolean isOccupied;
    private int departureTime;

    public Platform(int platformNumber) {
        this.platformNumber = platformNumber;
        this.isOccupied = false;
    }

    public boolean isAvailable(int arrivalTime) {
        return !isOccupied || arrivalTime >= departureTime;
    }

    public void assignTrain(int departureTime) {
        this.isOccupied = true;
        this.departureTime = departureTime;
    }

    public int getPlatformNumber() {
        return platformNumber;
    }
}
