import java.util.*;

public class RotationPoint {

    public static int findRotationPoint(int[] nums) {
        int LEFT = 0;
        int RIGHT = nums.length - 1;

        while (LEFT < RIGHT) {
            int mid = (LEFT + RIGHT ) / 2;

            if (nums[mid] > nums[RIGHT]) {
                LEFT = mid + 1;   // Finding smallest in right half
            } else {
                RIGHT = mid;     // Finding smallest in left half (including mid)
            }
        }
        return LEFT; // Finding index of smallest element
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int[] nums = new int[size];

        System.out.print("Enter the rotated sorted array: ");
        for(int i=0; i<size; i++) {
            nums[i] = sc.nextInt();
        }

        int index = findRotationPoint(nums);

        System.out.println("Point of rotation is at index: " + index);
        System.out.println("Smallest element in the array is: " + nums[index]);
    }
}
