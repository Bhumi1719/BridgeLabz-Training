import java.util.*;

public class powerCalculate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt(); // Base number
        int exponent = sc.nextInt(); // Exponent number

        // Calculate power using Math.pow method
        double result = Math.pow(base, exponent);

        // Print the result
        System.out.println(base + " raised to power of " + exponent + " is " + result);
    }
}