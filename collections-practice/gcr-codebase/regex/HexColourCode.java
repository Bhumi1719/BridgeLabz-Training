import java.util.Scanner;

public class HexColourCode {
    
    public static boolean isValidHexColorCode(String code) {
        return code.matches("^#[A-F0-9a-f]{6}$");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the hex code: ");
        String hexCode = sc.nextLine();

        System.out.print(isValidHexColorCode(hexCode));
    }
}
