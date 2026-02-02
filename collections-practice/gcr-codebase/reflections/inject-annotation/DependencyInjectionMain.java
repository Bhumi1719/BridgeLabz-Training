import java.util.Scanner;

public class DependencyInjectionMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create UserController with injected dependencies
        UserController controller = DIContainer.createInstance(UserController.class);

        System.out.print("Enter name to greet: ");
        String name = sc.nextLine();

        controller.sayHello(name);

        sc.close();
    }
}


