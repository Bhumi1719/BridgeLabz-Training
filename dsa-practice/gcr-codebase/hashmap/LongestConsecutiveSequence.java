import java.util.*;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        // Storing all the elements
        for(int num : arr) {
            map.put(num, true);
        }

        int longest = 0;

        for(int num : arr) {
            // Starting only if previous number is not present
            if(!map.containsKey(num - 1)) {
                int CURRENT = num;
                int COUNT = 1;

                while(map.containsKey(CURRENT + 1)) {
                    CURRENT++;
                    COUNT++;
                }
                longest = Math.max(longest, COUNT);
            }
        }
        return longest;
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

        int result = longestConsecutive(arr);
        System.out.println("Longest consecutive sequence length is " + result);
    }
}

