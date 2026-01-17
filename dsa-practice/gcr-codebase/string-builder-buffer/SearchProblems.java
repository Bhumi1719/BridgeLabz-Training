import java.util.*;

public class SearchProblems {

    // Method for finding the first missing positive using marking
    public static int firstMissingPositive(int[] nums) {
        boolean[] seen = new boolean[nums.length + 1];

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0 && nums[i] <= nums.length) {
                seen[nums[i]] = true;
            }
        }

        for(int i=1; i<=nums.length; i++) {
            if(!seen[i]) return i;
        }
        return nums.length + 1;
    }

    // Performing Binary search after sorting the array
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] nums = new int[size];

        System.out.print("Enter the elements of the array: ");
        for(int i=0; i<size; i++) {
            nums[i] = sc.nextInt();
        }

        int missing = firstMissingPositive(nums);
        System.out.println("First Missing Positive number is: " + missing);

        Arrays.sort(nums);

        System.out.print("Enter the target element for binary search: ");
        int target = sc.nextInt();


        int index = binarySearch(nums, target);
        System.out.println("Index of target elementafter sorting is: " + index);
    }
}
