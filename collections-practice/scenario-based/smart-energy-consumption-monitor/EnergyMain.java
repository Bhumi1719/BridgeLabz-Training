import java.util.*;

public class EnergyMain {

    public static void main(String[] args) {

        SmartEnergyMonitor monitor = new SmartEnergyMonitor();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Add Reading");
            System.out.println("2. Daily Average");
            System.out.println("3. Monthly Average");
            System.out.println("4. Report");
            System.out.println("5. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            try {
                switch(choice) {
                    case 1:
                        System.out.print("Enter energy value: ");
                        double value = sc.nextDouble();

                        monitor.addReading(new EnergyUsage(new Date(), value));
                        System.out.println("Reading added");
                        break;

                    case 2:
                        System.out.println("Daily Avg: " + monitor.calculateDailyAverage(new Date()));
                        break;

                    case 3:
                        System.out.print("Enter month (0-11): ");
                        int m = sc.nextInt();
                        System.out.print("Enter year: ");
                        int y = sc.nextInt();

                        System.out.println("Monthly Avg: " + monitor.calculateMonthlyAverage(m, y));
                        break;

                    case 4:
                        monitor.generateReport();
                        break;

                    case 5:
                        System.out.println("Exited");
                        System.exit(0);
                }
            } catch (InvalidEnergyReadingException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
