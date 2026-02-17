import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, ReliefCenter> centers = new HashMap<>();

        System.out.print("Enter Relief Center Name: ");
        String centerName = sc.nextLine();

        ReliefCenter center = new ReliefCenter(centerName);
        centers.put(centerName, center);

        System.out.print("Enter number of resources: ");
        int resCount = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<resCount; i++) {
            System.out.print("Enter Resource Name: ");
            String item = sc.nextLine();

            System.out.print("Enter Quantity: ");
            int qty = sc.nextInt();
            sc.nextLine();

            center.addResource(item, qty);
        }

        System.out.print("Enter number of area requests: ");
        int reqCount = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<reqCount; i++) {
            System.out.print("Enter Area Name: ");
            String area = sc.nextLine();

            System.out.print("Enter Resource Needed: ");
            String item = sc.nextLine();

            System.out.print("Enter Quantity Needed: ");
            int qty = sc.nextInt();
            sc.nextLine();

            center.addRequest(new AreaRequest(area, item, qty));
        }

        try {
            center.allocateResources();
        } 
        catch (InsufficientResourceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        center.generateReport();
    }
}
