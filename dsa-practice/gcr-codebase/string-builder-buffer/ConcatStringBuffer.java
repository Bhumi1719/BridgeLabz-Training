import java.util.*;

public class ConcatStringBuffer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of strings: ");
        int number = sc.nextInt();
        sc.nextLine();

        String[] arr = new String[number];

        System.out.println("Enter strings:");
        for(int i=0; i<number; i++) {
            arr[i] = sc.nextLine();
        }

        StringBuffer sb = new StringBuffer();

        for(int i=0; i<arr.length; i++) {
            sb.append(arr[i]);
        }

        System.out.println("Concatenated String is: " + sb.toString());
    }
}
