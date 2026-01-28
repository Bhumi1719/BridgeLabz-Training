import java.util.*;

public class ValidUsername {

    public static boolean isValidUsername(String username) {
        return username.matches("^[A-Za-z][A-Za-z0-9_]{4,14}$");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the username: ");
        String username = sc.nextLine();
        System.out.println(isValidUsername(username));
    }
}

