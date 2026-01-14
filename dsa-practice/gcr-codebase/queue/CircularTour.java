import java.util.*;

public class CircularTour {

    public static int findStart(int[] petrol, int[] distance) {
        int TOTAl = 0;
        int CURRENT = 0;
        int START = 0;

        for(int i=0; i<petrol.length; i++) {
            int diff = petrol[i] - distance[i];
            TOTAl += diff;
            CURRENT += diff;

            if(CURRENT < 0) {
                START = i + 1;
                CURRENT = 0;
            }
        }

        return (TOTAl >= 0) ? START : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of petrol pumps: ");
        int number = sc.nextInt();

        int[] petrol = new int[number];
        int[] distance = new int[number];

        System.out.print("Enter petrol at each pump: ");
        for(int i=0; i<number; i++) {
            petrol[i] = sc.nextInt();
        }

        System.out.print("Enter distance to next pump: ");
        for(int i=0; i<number; i++) {
            distance[i] = sc.nextInt();
        }

        int start = findStart(petrol, distance);

        if(start == -1)
            System.out.println("No possible circular tour.");
        else
            System.out.println("Start at petrol pump index: " + start);
    }
}
