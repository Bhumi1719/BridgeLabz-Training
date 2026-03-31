import java.util.Scanner;

public class FirstLastOccurrence {

    static int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                result = mid;
                right = mid - 1;   
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    static int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                left = mid + 1; 
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        int[] nums = new int[size];

        System.out.print("Enter the elements in the array: ");
        for(int i=0; i<size; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter the target element: ");
        int target = sc.nextInt();

        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        if(first == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("First Occurrence Index in the array is: " + first);
            System.out.println("Last Occurrence Index in the array is: " + last);
        }
    }
}
