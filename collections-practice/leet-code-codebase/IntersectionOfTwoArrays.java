import java.util.HashSet;
import java.util.*;

public class IntersectionOfTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();

        for(int n : nums1) {
            set.add(n);
        }

        for(int n : nums2) {
            if(set.contains(n)) {
                res.add(n);
            }
        }

        int[] ans = new int[res.size()];

        int i = 0;

        for(int n : res) {
            ans[i++] = n;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the first array: ");
        int size1 = sc.nextInt();

        int[] nums1 = new int[size1];

        System.out.println("Enter the elements of the array: ");
        for(int i=0; i<size1; i++) {
            nums1[i] = sc.nextInt();
        }

        System.out.print("Enter the size of the second array: ");
        int size2 = sc.nextInt();

        int[] nums2 = new int[size2];

        System.out.println("Enter the elements of the array: ");
        for(int i=0; i<size2; i++) {
            nums2[i] = sc.nextInt();
        }

        int[] result = intersection(nums1, nums2);
        System.out.print("The intersection of the two arrays is: ");
        for(int n : result) {
            System.out.print(n + " ");
        }
    }
}
