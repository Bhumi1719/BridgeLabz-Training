import java.util.Scanner;

public class SingleNumber {
    
    public static int singleNumber(int[] nums) {
        int RESULT = 0;
        for(int num : nums) {
            RESULT ^= num;
        }
        return RESULT;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int elements = sc.nextInt();

        int[] nums = new int[elements];

        System.out.print("Enter the elements: ");
        for(int i=0; i<elements; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("The single number in the array is: " + singleNumber(nums));
    }
}
