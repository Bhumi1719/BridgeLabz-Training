import java.util.*;

public class CircularTour {

    public static int findStart(int[] petrol, int[] distance) {
        int total = 0;
        int current = 0;
        int start = 0;

        for(int i=0; i<petrol.length; i++) {
            int diff = petrol[i] - distance[i];
            total += diff;
            current += diff;

            if(current < 0) {
                start = i + 1;
                current = 0;
            }
        }

        return (total >= 0) ? start : -1;
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
