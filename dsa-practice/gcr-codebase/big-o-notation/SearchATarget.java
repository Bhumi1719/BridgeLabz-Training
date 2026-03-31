import java.util.Arrays;
import java.util.Random;

public class SearchATarget {

    // Performing linear Search
    public static int linearSearch(int[] arr, int target) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Performing binary Search 
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        final int[] SIZES = {1000, 10000, 1000000};

        Random rand = new Random();

        for(int n : SIZES) {
            int[] arr = new int[n];

            for(int i=0; i<n; i++) {
                arr[i] = rand.nextInt(n * 2);
            }

            int target = arr[n / 2]; 

            // Linear Search Timing
            long startLinear = System.nanoTime();
            linearSearch(arr, target);
            long endLinear = System.nanoTime();

            // Sorting array for Binary Search
            int[] sortedArr = arr.clone();
            long sortStart = System.nanoTime();
            Arrays.sort(sortedArr);
            long sortEnd = System.nanoTime();

            // Binary Search Timing
            long startBinary = System.nanoTime();
            binarySearch(sortedArr, target);
            long endBinary = System.nanoTime();

            System.out.println("Dataset Size: " + n);
            System.out.println("Linear Search Time: " + (endLinear - startLinear) / 1_000_000.0 + " ms");
            System.out.println("Sorting Time: " + (sortEnd - sortStart) / 1_000_000.0 + " ms");
            System.out.println("Binary Search Time: " + (endBinary - startBinary) / 1_000_000.0 + " ms");
            System.out.println();
        }

        //Comparing the result now
        System.out.println("\nExpected Result:");
        System.out.println("Binary Search performs much better for large datasets, provided data is sorted.");
    }
}
