import java.util.Scanner;

public class ThirdMaximumNumber {
    
    public static int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for(Integer n : nums) {
            if(n.equals(max1) || n.equals(max2) || n.equals(max3)) {
                continue;
            }

            if(max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if(max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
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

        int result = thirdMax(nums);
        System.out.println("The third maximum number in the array is: " + result);
    }
}
