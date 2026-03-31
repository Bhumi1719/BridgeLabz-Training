import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of charging slots: ");
        int slotCount = sc.nextInt();

        System.out.print("Is it peak hour? (true/false): ");
        boolean isPeak = sc.nextBoolean();

        PricingStrategy strategy;

        if(isPeak) {
            strategy = new PeakHourPricing();
        } else {
            strategy = new NormalPricing();
        }

        ChargingStation station = new ChargingStation(strategy);

        for(int i=1; i<=slotCount; i++) {
            station.addSlot(i);
        }

        System.out.print("Enter number of vehicles: ");
        int vehicleCount = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<vehicleCount; i++) {
            System.out.print("Enter Vehicle Number: ");
            String number = sc.nextLine();

            System.out.print("Enter Units Consumed: ");
            double units = sc.nextDouble();
            sc.nextLine();

            station.addVehicle(new Vehicle(number, units));
        }

        try {
            for(int i=0; i<vehicleCount; i++) {
                station.allocateSlot();
            }
        } 
        catch (NoChargingSlotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
