import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        VesselUtil util = new VesselUtil();

        System.out.print("Enter the number of vessels: ");
        int vessels = Integer.parseInt(sc.nextLine());

        System.out.println("Enter vessel details: ");

        for(int i=0; i<vessels; i++) {
            String input = sc.nextLine();

            String[] data = input.split(":");
            String id = data[0];
            String name = data[1];
            double speed = Double.parseDouble(data[2]);
            String type = data[3];

            Vessel vessel = new Vessel(id, name, speed, type);
            util.addVesselPerformance(vessel);;
        }

        System.out.print("Enter the Vessel ID to check speed: ");
        String searchId = sc.nextLine();

        Vessel found = util.getVesselById(searchId);

        if(found != null) {
            System.out.println();
            System.out.print(found.getVesselId() + " | " + found.getVesselName() + " | " + found.getVesselType() + " | " + found.getAverageSpeed() + " knots");
        } else {
            System.out.print("Vessel ID " + searchId + " not found");
        }

        System.out.println("\nHigh performance vessels are: ");
        
        List<Vessel> highList = util.getHighPerformanceVessels();

        for(Vessel v : highList) {
            System.out.println(v.getVesselId() + " | " + v.getVesselName() + " | " + v.getVesselType() + " | " + v.getAverageSpeed() + " knots");
        }
    }
}
