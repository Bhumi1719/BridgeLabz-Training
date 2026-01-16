import java.util.*;

public class ZeroSumSubarrays {
    public static void findSubarrays(int[] arr) {

        // Creating a map to store the sum and list of indices
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Variable to store the sum
        int sum = 0;

        // For subarrays starting from index 0
        map.put(0, new ArrayList<>(Arrays.asList(-1)));

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];

            if(map.containsKey(sum)) {
                for(int startIndex : map.get(sum)) {
                    System.out.println("Subarray found from index " + (startIndex + 1) + " to " + i);
                }
            }

            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter the elements of the array:");

        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        findSubarrays(arr);
    }
}

