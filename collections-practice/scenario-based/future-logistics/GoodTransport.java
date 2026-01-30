public abstract class GoodTransport {
    protected String transportId;
    protected String transportDate;
    protected int transportRating;

    public GoodTransport(String transportDate, String transportId, int transportRating) {
        this.transportDate = transportDate;
        this.transportId = transportId;
        this.transportRating = transportRating;
    }

    public String getId() {
        return transportId;
    }

    public String getDate() {
        return transportDate;
    }

    public int getRating() {
        return transportRating;
    }

    public void setTransportId(String transportId) {
        this.transportId = transportId;
    }

    public void setTransportDate(String transportDate) {
        this.transportDate = transportDate;
    }

     public void setTransportRating(int transportRating) {
        this.transportRating = transportRating;
    }

    public abstract String vehicleSelection();
    public abstract float calculateTotalCharge();
}
