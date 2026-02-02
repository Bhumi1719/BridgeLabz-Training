import java.lang.reflect.Proxy;
import java.util.Scanner;

public class CustomLoggingProxy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Greeting greeting = new GreetingImplement();

        // Creating dynamic proxy
        Greeting proxy = (Greeting) Proxy.newProxyInstance(greeting.getClass().getClassLoader(), new Class[]{Greeting.class}, new LoggingHandler(greeting));

        System.out.println("Choose method to call:");
        System.out.println("1. sayHello");
        System.out.println("2. sayGoodbye");

        System.out.print("\nEnter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        switch (choice) {
            case 1 -> proxy.sayHello(name);
            case 2 -> proxy.sayGoodbye(name);
            default -> System.out.println("Invalid choice!");
        }

        sc.close();
    }
}

