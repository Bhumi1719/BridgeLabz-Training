import java.util.*;

public class ParkingSystem {

    private Map<Integer, ParkingSlot> slots = new HashMap<>();
    private Queue<Vehicle> waitingQueue = new LinkedList<>();

    public void addSlot(ParkingSlot slot) {
        slots.put(slot.getSlotNumber(), slot);
    }

    public void addVehicle(Vehicle vehicle) {
        waitingQueue.offer(vehicle);
    }

    public void allocateSlots() {

        while (!waitingQueue.isEmpty()) {

            Vehicle vehicle = waitingQueue.poll();

            Optional<ParkingSlot> slot = slots.values().stream()
                    .filter(s -> !s.isOccupied() && s.getVehicleType().equalsIgnoreCase(vehicle.getType()))
                    .sorted(Comparator.comparing(ParkingSlot::getSlotNumber))
                    .findFirst();

            if(slot.isPresent()) {
                slot.get().park();
                System.out.println("\n" + vehicle.getVehicleNumber() + " parked at Slot " + slot.get().getSlotNumber());
            } else {
                System.out.println("No slot available for " + vehicle.getVehicleNumber());
            }
        }
    }
}
