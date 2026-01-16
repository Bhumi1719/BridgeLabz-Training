import java.util.Scanner;

public class EventManager {

    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        final int PIVOT = arr[high];   // last element as pivot
        int index = low - 1;

        for(int j=low; j<high; j++) {
            if(arr[j] < PIVOT) {
                index ++;

                int temp = arr[index];
                arr[index] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[index + 1];
        arr[index + 1] = arr[high];
        arr[high] = temp;

        return index + 1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of tickets: ");
        int tickets = sc.nextInt();

        int[] prices = new int[tickets];

        System.out.println("\nEnter ticket prices");
        for(int i=0; i<tickets; i++) {
            System.out.print("Enter the price for ticket " + (i+1) + ": ");
            prices[i] = sc.nextInt();
        }

        quickSort(prices, 0, tickets - 1); // Calling the method to perform quick sort

        System.out.println("\nSorted Ticket Prices:");
        for(int price : prices) {
            System.out.print(price + " ");
        }

        System.out.print("\n\nShow how many top tickets? ");
        int topticket= sc.nextInt();

        System.out.println("\nCheapest " + topticket + " tickets:");
        for(int i=0; i<topticket && i<tickets; i++) {
            System.out.print(prices[i] + " ");
        }

        System.out.println("\nMost Expensive " + topticket + " tickets:");
        for(int i=tickets - 1; i>=tickets - topticket && i >= 0; i--) {
            System.out.print(prices[i] + " ");
        }
    }
}
