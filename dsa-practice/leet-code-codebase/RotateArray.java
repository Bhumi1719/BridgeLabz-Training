import java.util.Scanner;

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        if(nums.length == 1){
            return;
        }

        k = k % nums.length;
        rev(nums, 0, nums.length-1-k);
        rev(nums, nums.length-k, nums.length-1);
        rev(nums, 0, nums.length-1);
    }

    public static void rev(int[] arr, int p1, int p2){
        while(p1 < p2){
            swap(arr, p1, p2);
            p1++;
            p2--;                 
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] nums = new int[size];
        System.out.print("Enter the elements of the array: ");
        for(int i = 0; i < size; i++){
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter the number of rotations: ");
        int rotation = sc.nextInt();

        rotate(nums, rotation);

        System.out.println("Rotated Array: ");
        for(int num : nums){
            System.out.print(num + " ");
        }
    }
}