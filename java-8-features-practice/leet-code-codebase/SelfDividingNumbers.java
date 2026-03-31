import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelfDividingNumbers {
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();

        int m = left;
        int n = right;

        for(int i=left; i<=right; i++) {
            int count = 0;
            int counts = 0;
            int temp = i;
            int num = i;

            while(num > 0){
                int temps = num % 10;
                count++;

                if(temps != 0 && temp % temps == 0) {
                counts++;
                }

                num /= 10;
            }

            if(count == counts){
                list.add(temp);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the left number: ");
        int left = sc.nextInt();
        System.out.print("Enter the right number: ");
        int right = sc.nextInt();

        List<Integer> res = selfDividingNumbers(left, right);
        
        System.out.print("The self-dividing numbers are: ");
        for(int num : res) {
            System.out.print(num + " ");
        }
    }
}