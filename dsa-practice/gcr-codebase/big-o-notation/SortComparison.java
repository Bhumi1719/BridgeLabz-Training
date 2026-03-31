import java.util.Arrays;
import java.util.Random;

public class SortComparison {

    // Performing Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n - 1; i++) {
            for(int j=0; j<n - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Performing Merge Sort
    public static void mergeSort(int[] arr, int l, int r) {
        if(l < r) {
            int mid = (l + r) / 2;

            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i=0; i<n1; i++) {
            left[i] = arr[l + i];
        }

        for(int j=0; j<n2; j++) {
            right[j] = arr[m + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while(i < n1 && j < n2) {
            if(left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while(i < n1) {
            arr[k++] = left[i++];
        }

        while(j < n2) {
            arr[k++] = right[j++];
        }
    }

    // Performing Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for(int j=low; j<high; j++) {
            if(arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {

        final int[] SIZES = {1000, 10000, 100000};
        Random rand = new Random();

        for(int n : SIZES) {
            int[] arr = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = rand.nextInt(n);
            }

            int[] a1 = arr.clone();
            int[] a2 = arr.clone();
            int[] a3 = arr.clone();

            System.out.println("Dataset Size: " + n);

            long t1 = System.nanoTime();
            bubbleSort(a1);
            long t2 = System.nanoTime();
            System.out.println("Bubble Sort: " + (t2 - t1) / 1_000_000.0 + " ms");

            long t3 = System.nanoTime();
            mergeSort(a2, 0, a2.length - 1);
            long t4 = System.nanoTime();
            System.out.println("Merge Sort: " + (t4 - t3) / 1_000_000.0 + " ms");

            long t5 = System.nanoTime();
            quickSort(a3, 0, a3.length - 1);
            long t6 = System.nanoTime();
            System.out.println("Quick Sort: " + (t6 - t5) / 1_000_000.0 + " ms");

            System.out.println();

        }
        
        //Comparing the result now
        System.out.println("\nExpected Result:");
        System.out.println("Bubble Sort is impractical for large datasets.");
        System.out.println("Merge Sort & Quick Sort perform well.");
    }
}
