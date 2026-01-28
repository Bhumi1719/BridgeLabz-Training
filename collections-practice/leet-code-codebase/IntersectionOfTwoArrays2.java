import java.util.*;

public class IntersectionOfTwoArrays2 {
    
    public static int[] intersect(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0;
        int j = 0;
        int k = 0;

        int[] res = new int[Math.min(arr1.length, arr2.length)];

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] == arr2[j]) { 
                res[k++] = arr1[i++];
                j++;
            } else if(arr1[i] < arr2[j]) { 
                i++;
            } else {
               j++; 
            } 
        }
        return Arrays.copyOf(res, k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of first array: ");
        int size1 = sc.nextInt();

        int[] arr1 = new int[size1];

        System.out.println("Enter the elements of the first array:");
        for(int i=0; i<size1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.print("Enter the size of second array: ");
        int size2 = sc.nextInt();

        int[] arr2 = new int[size2]; 

        System.out.println("Enter the elements of the second array:");
        for(int i=0; i<size2; i++) {
            arr2[i] = sc.nextInt();
        }

        int[] intersection = intersect(arr1, arr2);
        System.out.println("Intersection of the two arrays is: ");
        for(int i : intersection) {
            System.out.print(i + " " );
        }
    }
}
