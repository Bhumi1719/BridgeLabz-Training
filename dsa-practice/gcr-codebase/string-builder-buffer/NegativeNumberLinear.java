import java.util.*;

public class NegativeNumberLinear {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] nums = new int[size];

        System.out.println("Enter the elements of the array:");
        for(int i=0; i<size; i++) {
            nums[i] = sc.nextInt();
        }

        int INDEX = -1;

        for (int i = 0; i < size; i++) {
            if(nums[i] < 0) {
                INDEX = i;
                break;
            }
        }

        if(INDEX != -1)
            System.out.println("First negative number found at index: " + INDEX);
        else
            System.out.println("-1(No negative number found in the array)");
    }
}
