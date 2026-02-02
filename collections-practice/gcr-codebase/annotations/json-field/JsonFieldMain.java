import java.util.Scanner;

public class JsonFieldMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        User user = new User(username, age, password);

        String json = JsonSerializer.toJson(user);
        System.out.println("\nGenerated JSON:");
        System.out.println(json);

        sc.close();
    }
}
