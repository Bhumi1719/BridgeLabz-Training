public class StandardRoom extends Room {
    public StandardRoom(int roomNumber) {
        super(roomNumber, 1500);
    }

    @Override
    public String getType() {
        return "Standard";
    }
}

