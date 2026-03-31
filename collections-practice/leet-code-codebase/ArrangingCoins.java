import java.util.Scanner;

public class ArrangingCoins {
    public static int arrangeCoins(int number) {
        long N = number;
        return (int)((Math.sqrt(8 * N + 1) - 1) / 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        System.out.print("The number of rows are: " + arrangeCoins(number));
    }
}
