import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FlightUtil util = new FlightUtil();

        try {
            System.out.print("Enter flight number: ");
            String flightNumber = sc.nextLine();
            util.validateFlightNumber(flightNumber);

            System.out.print("Enter flight name: ");
            String flightName = sc.nextLine();
            util.validateFlightName(flightName);

            System.out.print("Enter passenger count: ");
            int passengerCount = sc.nextInt();
            util.validatePassengerCount(passengerCount, flightName);

            System.out.print("Enter current fuel level: ");
            double currentFuelLevel = sc.nextDouble();

            double fuelRequired = util.calculateFuelToFillTank(flightName, currentFuelLevel);

            System.out.println("Fuel required to fill the tank: " + fuelRequired + " liters");

        } catch (InvalidFlightException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
