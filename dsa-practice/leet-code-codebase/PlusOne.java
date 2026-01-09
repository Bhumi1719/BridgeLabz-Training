import java.util.*;

public class PlusOne {
    
    public static int[] plusOne(int[] digits) {
        for(int i=digits.length - 1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i] ++;
                return digits;
            }

            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] nums = new int[size];

        System.out.println("Enter the elements of array: ");
        for(int i=0; i<size; i++) {
            nums[i] = sc.nextInt();
        }

        int[] result = plusOne(nums);

        System.out.println("The resultant array is: ");
        for(int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
