import java.util.Scanner;

public class LicensePlateNumber {
    public static boolean isValidNumberPlate(String input) {
        return input.matches("^[A-Z]{2}[0-9]{4}$");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the license plate number: ");
        String plateNumber = sc.nextLine();

        System.out.print(isValidNumberPlate(plateNumber));
    }
}
