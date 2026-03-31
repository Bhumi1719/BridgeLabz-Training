interface Vehicle {

    void displaySpeed();

    // Uising default method for new feature
    default void displayBattery() {
        System.out.println("Battery feature not available for this vehicle.");
    }
}