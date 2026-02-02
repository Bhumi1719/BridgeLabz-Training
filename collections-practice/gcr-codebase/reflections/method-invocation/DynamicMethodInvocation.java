import java.lang.reflect.Method;
import java.util.*;

public class DynamicMethodInvocation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter method name (add / subtract / multiply): ");
            String methodName = sc.nextLine();

            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            // Creating an object
            MathOperations obj = new MathOperations();

            // Getting Class object
            Class<?> cls = obj.getClass();

            // Getting method dynamically
            Method method = cls.getMethod(methodName, int.class, int.class);

            int result = (int) method.invoke(obj, a, b);

            System.out.println("Result is: " + result);

        } catch (NoSuchMethodException e) {
            System.out.println("Invalid method name!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}