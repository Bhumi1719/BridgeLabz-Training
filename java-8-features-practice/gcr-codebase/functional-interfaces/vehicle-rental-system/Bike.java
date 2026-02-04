public class Bike implements Vehicle {
    
    @Override
    public void rent() {
        System.out.println("Bike is given on rent");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Bike is returned");
    }
}
