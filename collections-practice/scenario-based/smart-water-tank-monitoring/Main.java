import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<WaterTank> tanks = new ArrayList<>();

        System.out.print("Enter number of tanks: ");
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            try {
                System.out.print("Enter Tank ID: ");
                int id = sc.nextInt();

                System.out.print("Enter Capacity: ");
                double capacity = sc.nextDouble();

                System.out.print("Enter Current Level: ");
                double level = sc.nextDouble();

                WaterTank tank = new WaterTank(id, capacity, level);
                tanks.add(tank);

            } catch (InvalidWaterLevelException e) {
                System.out.println("Error: " + e.getMessage());
                i--; 
            }
        }

        Collections.sort(tanks, new Comparator<WaterTank>() {
            @Override
            public int compare(WaterTank t1, WaterTank t2) {
                return Double.compare(t1.getCurrentLevel(), t2.getCurrentLevel());
            }
        });

        System.out.println("\nTank Details (Sorted by Lowest Level)");
        for(WaterTank tank : tanks) {
            System.out.println(tank);
            tank.checkAlert();
        }
    }
}
