import java.util.Scanner;

public class NimGame {
    public static boolean canWinNim(int n) {
        
        if(n % 4 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        System.out.print("Can I win the game? " + canWinNim(number));
    }
}