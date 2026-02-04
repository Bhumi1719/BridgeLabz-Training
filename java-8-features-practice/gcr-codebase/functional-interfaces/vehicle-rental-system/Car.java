public class Car implements Vehicle{

    @Override
    public void rent() {
        System.out.println("Car is given on rent");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Car is returned");
    }
}
