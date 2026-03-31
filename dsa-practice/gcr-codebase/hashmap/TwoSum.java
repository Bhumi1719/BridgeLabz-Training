import java.util.*;

public class Twosum {
    public static int[] findTwoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            int result = target - arr[i];
            if(map.containsKey(result)) {
                return new int[]{map.get(result), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1}; // If not found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.print("Enter the array elements: ");
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the target sum: ");
        int target = sc.nextInt();

        int[] result = findTwoSum(arr, target);

        if(result[0] != -1)
            System.out.println("Indices: " + result[0] + " and " + result[1]);
        else
            System.out.println("No two sum solution found");
    }
}

