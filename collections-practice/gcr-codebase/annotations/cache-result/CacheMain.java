import java.lang.reflect.Method;
import java.util.Scanner;

public class CacheMain {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        Method method = Calculator.class.getMethod("factorial", int.class);

        if(!method.isAnnotationPresent(CacheResult.class)) {
            System.out.println("Method not cacheable!");
            sc.close();
            return;
        }

        while(true) {
            System.out.print("Enter number to compute factorial (-1 to exit): ");
            int n = sc.nextInt();

            if(n == -1) {
                break;
            }

            int result = (int) method.invoke(calc, n);
            
            System.out.println("Factorial of " + n + " = " + result + "\n");
        }

        sc.close();
    }
}
