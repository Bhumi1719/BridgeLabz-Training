import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password to check: ");
        String password = sc.nextLine();

        if(SecurityUtils.isStrongPassword(password)) {
            System.out.println("Password is strong");
        } else {
            System.out.println("Password is weak");
        }

    }
}