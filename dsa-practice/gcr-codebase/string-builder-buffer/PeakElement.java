import java.util.Scanner;

public class PeakElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        int[] nums = new int[size];

        System.out.print("Enter the elements in the array: ");
        for(int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }

        int peakIndex = findPeak(nums);
        System.out.println("Peak element in the array is " + nums[peakIndex] + " at index " + peakIndex);
    }

    public static int findPeak(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            int leftVal = (mid == 0) ? Integer.MIN_VALUE : nums[mid - 1];
            int rightVal = (mid == nums.length - 1) ? Integer.MIN_VALUE : nums[mid + 1];

            if(nums[mid] > leftVal && nums[mid] > rightVal) {
                return mid; // peak found
            } else if (nums[mid] < leftVal) {
                right = mid - 1; // For going left
            } else {
                left = mid + 1; // For going right
            }
        }
        return -1; 
    }
}
