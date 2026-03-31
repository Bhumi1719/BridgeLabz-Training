import java.util.Scanner;

public class SmallestRange1 {
    public static int smallestRangeI(int[] nums, int k) {
      int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;

        for(int val:nums){

            if(val < min){
                min=val;
            }

            if(val > max) {
                max=val;
            }

        }
        return (min + k) > (max - k) ? 0 : (max - k) - (min + k);
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

        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();

        System.out.print("Minimum score of nums is: " + smallestRangeI(nums, k));
    }
}

