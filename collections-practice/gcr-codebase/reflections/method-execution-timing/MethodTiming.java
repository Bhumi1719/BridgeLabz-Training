import java.lang.reflect.Method;
import java.util.Scanner;

public class MethodTiming {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Creating object
            MathOperations obj = new MathOperations();

            // Getting class object
            Class<?> cls = obj.getClass();

            System.out.println("Available methods:");
            for(Method m : cls.getDeclaredMethods()) {
                System.out.println("- " + m.getName());
            }

            System.out.print("\nEnter method name to execute: ");
            String methodName = sc.nextLine();

            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            // Getting method dynamically
            Method method = cls.getMethod(methodName, int.class, int.class);

            // Measuring execution time
            long startTime = System.nanoTime();
            method.invoke(obj, a, b);
            long endTime = System.nanoTime();

            System.out.println("\nExecution time: " + (endTime - startTime) + " ns");

        } catch (NoSuchMethodException e) {
            System.out.println("Invalid method name!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
