import java.util.Scanner;

public class LongPressedName {
    public static boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int m = name.length();
        int n = typed.length();

        for(int j=0; j<n; ++j)
            if(i < m && name.charAt(i) == typed.charAt(j)) {
                ++i;
            } else if(j == 0 || typed.charAt(j) != typed.charAt(j - 1)) {
                return false;
            }
        return i == m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the name: ");
        String name = sc.nextLine();

        System.out.print("Enter the typed word: ");
        String typed = sc.nextLine();

        System.out.print("Is the typed word your friends name? " + isLongPressedName(name, typed));
    }
}
