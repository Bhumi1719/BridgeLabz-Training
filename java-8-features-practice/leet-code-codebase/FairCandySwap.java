import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.IntStream;

public class FairCandySwap {
    public static int[] fairCandySwap(int[] A, int[] B) {
        int dif = (IntStream.of(A).sum() - IntStream.of(B).sum()) / 2;

        HashSet<Integer> S = new HashSet<>();

        for(int a : A) {
            S.add(a);
        }

        for(int b : B) {
            if(S.contains(b + dif)) {
                return new int[] {b + dif, b};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of candies Alice has: ");
        int n = sc.nextInt();

        int[] A = new int[n];
        System.out.println("Enter the sizes of Alice's candies:");  
        for(int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        System.out.print("Enter the number of candies Bob has: ");
        int m = sc.nextInt();

        int[] B = new int[m];
        System.out.println("Enter the sizes of Bob's candies:");  
        for(int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }

        int[] result = fairCandySwap(A, B);
        System.out.println("Alice and Bob should exchange candies of sizes: " + result[0] + " and " + result[1]);
    }
}
