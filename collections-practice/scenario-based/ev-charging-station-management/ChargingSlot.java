public class ChargingSlot {

    private int slotId;
    private boolean occupied;

    public ChargingSlot(int slotId) {
        this.slotId = slotId;
        this.occupied = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void occupy() {
        occupied = true;
    }

    public void release() {
        occupied = false;
    }

    public int getSlotId() {
        return slotId;
    }
}
