import java.util.*;

public class RotateList {

    public static void rotate(List<Integer> list, int k) {
        int n = list.size();
        k = k % n; // handle rotations > size

        // Reversing the first k elements
        reverse(list, 0, k - 1);
        // Reverse the remaining elements
        reverse(list, k, n - 1);
        // Reversing the whole list
        reverse(list, 0, n - 1);
    }

    public static void reverse(List<Integer> list, int start, int end) {
        while(start < end) {
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int size = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        System.out.print("Enter the elements: ");
        for(int i=0; i<size; i++) {
            list.add(sc.nextInt());
        }

        System.out.print("Enter the rotation value: ");
        int k = sc.nextInt();

        rotate(list, k);

        System.out.println("\nRotated List is: " + list);
    }
}
