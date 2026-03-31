abstract class Vehicle {
    private String vehicleNumber;

    public Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    String getVehicleNumber() {
        return vehicleNumber;
    }

    public abstract String getType();
}
