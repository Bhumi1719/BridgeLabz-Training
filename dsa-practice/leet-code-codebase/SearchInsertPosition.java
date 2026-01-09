import java.util.*;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {

        int INDEX = 0 ;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == target){
                INDEX = i;
            } else if(target <= nums[nums.length - 1]){
                if(target > nums[i] && target <nums[i+1]){
                    INDEX = i+1;
                }
            } else
                INDEX = nums.length;
        }

        return INDEX;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] nums = new int[size];

        System.out.println("Enter the elements of the array: ");
        for(int i=0; i<size; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter the target element: ");
        int target = sc.nextInt();

        System.out.println("The target element is inserted at the index: " + searchInsert(nums, target));
    }
}
