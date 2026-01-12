public class Room {
    protected int roomNumber;
    protected boolean isAvailable = true;
    protected double basePrice;

    public Room(int roomNumber, double basePrice) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void book() {
        isAvailable = false;
    }

    public void free() {
        isAvailable = true;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getType() {
        return "Room";
    }
}
