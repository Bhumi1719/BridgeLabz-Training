public class Light implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("\nLight is turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("\nLight is turned OFF");
    }
}