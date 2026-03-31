public class DeluxeRoom extends Room {
    public DeluxeRoom(int roomNumber) {
        super(roomNumber, 3000);
    }

    @Override
    public String getType() {
        return "Deluxe";
    }
}
