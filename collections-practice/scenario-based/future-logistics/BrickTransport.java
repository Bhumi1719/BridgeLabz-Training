public class BrickTransport extends GoodTransport {
    private float brickSize;
    private int brickQuantity;
    private float brickPrice;

    public BrickTransport(String transportId, String transportDate, float brickPrice, int brickQuantity, float brickSize, int transportRating) {
        super(transportDate, transportId, transportRating);
        this.brickPrice = brickPrice;
        this.brickQuantity = brickQuantity;
        this.brickSize = brickSize;
    }

    public float getBrickSize() {
        return brickSize;
    }

    public float getBrickPrice() {
        return brickPrice;
    }

    public int getBrickQuantity() {
        return brickQuantity;
    }

    public void setBrickSize(float brickSize) {
        this.brickSize = brickSize;
    }

    public void setBrickPrice(float brickPrice) {
        this.brickPrice = brickPrice;
    }

    public void setBrickQuantity(int brickQuantity) {
        this.brickQuantity = brickQuantity;
    }

    @Override
    public String vehicleSelection() {
        if(brickQuantity < 300) {
            return "Truck";
        } else if(brickQuantity >= 300 && brickQuantity <= 500) {
            return "Lorry";
        } else {
            return "MonsterLorry";
        }
    }

    @Override
    public float calculateTotalCharge() {
        float price = brickPrice * brickQuantity;
        float tax = price * 0.3f;

        float discount = 0;

        if(transportRating == 5) {
            discount = price * 0.20f;
        } else if (transportRating == 3 || transportRating == 4) {
            discount = price * 0.10f;
        }

        float vehiclePrice = Utility.getVehiclePrice(vehicleSelection());

        return (price + tax + vehiclePrice) - discount;
    }
}
