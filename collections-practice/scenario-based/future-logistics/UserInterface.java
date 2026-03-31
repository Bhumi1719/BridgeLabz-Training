import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Utility utility = new Utility();

        System.out.print("Enter Transport Id (Example: RTS123A): ");
        String transportId = sc.nextLine();

        if(!utility.validateTransportId(transportId)) {
            System.out.println("Please provide a valid record");
            return;
        }

        System.out.print("Enter Transport Date (dd/mm/yy): ");
        String transportDate = sc.nextLine();

        System.out.print("Enter Transport Rating (1 to 5): ");
        int rating = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Transport Type (BrickTransport / TimberTransport): ");
        String transportType = sc.nextLine();

        String input = "";

        if(transportType.equalsIgnoreCase("BrickTransport")) {

            System.out.print("Enter Brick Size: ");
            float brickSize = Float.parseFloat(sc.nextLine());

            System.out.print("Enter Brick Quantity: ");
            int brickQuantity = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Brick Price: ");
            float brickPrice = Float.parseFloat(sc.nextLine());

            input = transportId + ":" + transportDate + ":" + rating + ":" + transportType + ":" + brickSize + ":" + brickQuantity + ":" + brickPrice;

        } else if(transportType.equalsIgnoreCase("TimberTransport")) {

            System.out.print("Enter Timber Length: ");
            float timberLength = Float.parseFloat(sc.nextLine());

            System.out.print("Enter Timber Radius: ");
            float timberRadius = Float.parseFloat(sc.nextLine());

            System.out.print("Enter Timber Type (Premium / NonPremium): ");
            String timberType = sc.nextLine();

            System.out.print("Enter Timber Price per kilo: ");
            float timberPrice = Float.parseFloat(sc.nextLine());

            input = transportId + ":" + transportDate + ":" + rating + ":" + transportType + ":" + timberLength + ":" + timberRadius + ":" + timberType + ":" + timberPrice;
        } else {
            System.out.println("Invalid Transport Type");
            return;
        }

        GoodTransport gt = utility.parseDetails(input);
        String type = utility.findObjectType(gt);

        System.out.println("\nTransporter id : " + gt.getId());
        System.out.println("Date of transport : " + gt.getDate());
        System.out.println("Rating of the transport : " + gt.getRating());

        if(type.equals("BrickTransport")) {
            BrickTransport bt = (BrickTransport) gt;
            System.out.println("Quantity of bricks : " + bt.getBrickQuantity());
            System.out.println("Brick price : " + bt.getBrickPrice());
        } else {
            TimberTransport tt = (TimberTransport) gt;
            System.out.println("Type of the timber : " + tt.getTimberType());
            System.out.println("Timber price per kilo : " + tt.getTimberPrice());
        }

        System.out.println("Vehicle for transport : " + gt.vehicleSelection());
        System.out.println("Total charge : " + gt.calculateTotalCharge());
    }
}
