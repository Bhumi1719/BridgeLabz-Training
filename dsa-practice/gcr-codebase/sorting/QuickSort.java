import java.util.*;

public class QuickSort {
    
    public static void quickSort(int[] prices, int low, int high) {
        if(low < high) {
            int pi = partition(prices, low, high);
            quickSort(prices, low, pi - 1);
            quickSort(prices, pi + 1, high);
        }
    }

    private static int partition(int[] prices, int low, int high) {
        int PIVOT = prices[high];
        int START = low - 1;
        for(int j=low; j<high; j++) {
            if(prices[j] < PIVOT) {
                START ++;
                int temp = prices[START];
                prices[START] = prices[j];
                prices[j] = temp;
            }
        }
        int temp = prices[START + 1];
        prices[START + 1] = prices[high];
        prices[high] = temp;
        return START + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int products = sc.nextInt();

        int[] prices = new int[products];

        System.out.print("Enter the price of each product: ");
        for(int i=0; i<prices.length; i++) {
            prices[i] = sc.nextInt();
        }

        quickSort(prices, 0, prices.length-1);
        System.out.print("The price of each product in ascending order is: " + Arrays.toString(prices));
    }
}
