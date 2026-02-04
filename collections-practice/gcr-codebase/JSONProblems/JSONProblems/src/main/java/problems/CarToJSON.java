package problems;

import java.util.Scanner;
import org.json.JSONObject;

public class CarToJSON {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter car brand: ");
        String brand = sc.nextLine();

        System.out.print("Enter car model: ");
        String model = sc.nextLine();

        System.out.print("Enter car year: ");
        int year = sc.nextInt();

        Car car = new Car(brand, model, year);

        // Converting Car object to JSON
        JSONObject carJson = new JSONObject();
        carJson.put("brand", car.getBrand());
        carJson.put("model", car.getModel());
        carJson.put("year", car.getYear());

        System.out.println("\nCar Details in JSON Format:");
        System.out.println(carJson.toString()); 
    }
}
