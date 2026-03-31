import java.util.Scanner;

public class CelciusToFah {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Takes input in Celsius
        double c = sc.nextDouble();

        // Converts Celsius to Fahrenheit
        double f = (c * 9/5) + 32;

        // Prints the result
        System.out.println("Fahrenheit: " + f);
    }
}
