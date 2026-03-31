import java.lang.reflect.Method;
import java.util.Scanner;

public class InvokePrivateMethod {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            // Creating an object of the Calculator class
            Calculator calc = new Calculator();

            Class<?> cls = calc.getClass();
            Method method = cls.getDeclaredMethod("multiply", int.class, int.class);
            method.setAccessible(true);
            
            int result = (int) method.invoke(calc, a, b);

            System.out.println("Multiplication Result: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}


