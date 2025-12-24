import java.util.*;

public class EvenOddCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int number = sc.nextInt();

        int[] arr = new int[number];

        System.out.print("Enter the elements in the array: ");
        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int EVEN_COUNT = 0;
        int ODD_COUNT = 0;

    
        for(int i=0; i<arr.length; i++) {
            if(arr[i] >= 0) {
                if(arr[i] % 2 == 0) {
                EVEN_COUNT ++;
                } else {
                ODD_COUNT ++;
            }
            } else {
                System.out.println("Enter positive number");
                break;
            }
        }

        System.out.println("Even elements in the array are: " + EVEN_COUNT);
        System.out.println("Odd elements in the array are: " + ODD_COUNT);
    }
}