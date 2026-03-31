public class Utility {

    public GoodTransport parseDetails(String input) {
        String[] data = input.split(":");

        String transportId = data[0];
        String transportDate = data[1];
        int rating = Integer.parseInt(data[2]);
        String transportType = data[3];

        if(transportType.equalsIgnoreCase("BrickTransport")) {
            return new BrickTransport(transportId, transportDate, Float.parseFloat(data[4]), Integer.parseInt(data[5]), Float.parseFloat(data[6]), rating);
        } else {
            return new TimberTransport(
                    transportId,
                    transportDate,
                    rating,
                    Float.parseFloat(data[4]),
                    Float.parseFloat(data[5]),
                    data[6],
                    Float.parseFloat(data[7])
            );
        }
    }

    public boolean validateTransportId(String transportId) {
        if (!transportId.matches("RTS\\d{3}[A-Z]")) {
            System.out.println("Transport id " + transportId + " is invalid");
            return false;
        }
        return true;
    }

    public String findObjectType(GoodTransport goodsTransport) {
        if (goodsTransport instanceof TimberTransport)
            return "TimberTransport";
        else
            return "BrickTransport";
    }

    public static float getVehiclePrice(String vehicle) {
        if (vehicle.equalsIgnoreCase("Truck"))
            return 1000;
        else if (vehicle.equalsIgnoreCase("Lorry"))
            return 1700;
        else
            return 3000;
    }
}
