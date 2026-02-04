public class ElectricCar implements Vehicle {

    @Override
    public void displaySpeed() {
        System.out.println("Electric Car Speed: 70 km/h");
    }

    // Overriding default method
    @Override
    public void displayBattery() {
        System.out.println("Battery Percentage: 85%");
    }
}