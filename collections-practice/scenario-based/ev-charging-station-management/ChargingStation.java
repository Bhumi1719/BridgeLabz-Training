import java.util.*;

public class ChargingStation {

    private Map<Integer, ChargingSlot> slots = new HashMap<>();
    private Queue<Vehicle> waitingQueue = new LinkedList<>();
    private PricingStrategy pricingStrategy;

    public ChargingStation(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public void addSlot(int slotId) {
        slots.put(slotId, new ChargingSlot(slotId));
    }

    public void addVehicle(Vehicle vehicle) {
        waitingQueue.offer(vehicle);
    }

    public void allocateSlot() throws NoChargingSlotAvailableException {

        for(ChargingSlot slot : slots.values()) {

            if(!slot.isOccupied() && !waitingQueue.isEmpty()) {

                Vehicle vehicle = waitingQueue.poll();
                slot.occupy();

                double bill = pricingStrategy.calculateBill(vehicle.getUnitsConsumed());

                System.out.println("Slot " + slot.getSlotId() + " allocated to " + vehicle.getVehicleNumber());
                System.out.println("Units Consumed: " + vehicle.getUnitsConsumed());
                System.out.println("Bill: $" + bill);

                slot.release(); 
                return;
            }
        }

        throw new NoChargingSlotAvailableException("No charging slot available!");
    }
}
