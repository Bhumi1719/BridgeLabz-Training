import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<n; i++) {

            // Remove elements out of this window
            if(!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements from back
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            // Store result when first window is complete
            if(i >= k - 1) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int number = sc.nextInt();

        int[] arr = new int[number];

        System.out.print("Enter elements: ");
        for(int i=0; i<number; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter window size k: ");
        int k = sc.nextInt();

        int[] ans = maxSlidingWindow(arr, k);

        System.out.print("Sliding Window Maximums: ");
        for(int x : ans) {
            System.out.print(x + " ");
        }
    }
}

