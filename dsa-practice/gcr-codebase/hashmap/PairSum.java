import java.util.*;

public class PairSum {
    public static boolean hasPair(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : arr) {
            int need = target - num;
            if(map.containsKey(need)) {
                return true;   // Pair found
            }
            map.put(num, 1);   // Mark as visited
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.print("Enter array elements:");
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        if(hasPair(arr, target)) {
            System.out.println("Pair exists with given sum");
        } else {
            System.out.println("No pair exists with given sum");
        }
    }
}
