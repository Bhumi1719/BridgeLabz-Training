import java.util.Scanner;

public class TeemoAttacking {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0;
        for(int i=0; i<timeSeries.length-1; i++) {
            if(timeSeries[i+1] <= timeSeries[i] + duration-1) {
                total += timeSeries[i+1] - timeSeries[i];
            } else { 
                total += duration;
            }
        }

        total += duration; 
        return total;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of attacks: ");
        int n = sc.nextInt();

        int[] timeSeries = new int[n];
        System.out.println("Enter the time series of attacks:");
        for(int i=0; i<n; i++) {
            timeSeries[i] = sc.nextInt();
        }

        System.out.print("Enter the duration of poison: ");
        int duration = sc.nextInt();

        int result = findPoisonedDuration(timeSeries, duration);
        System.out.println("Total poisoned duration: " + result);
        
    }
}