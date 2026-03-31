package problems;

import org.json.JSONObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExtractJSONFields {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter JSON file path: ");
        String filePath = sc.nextLine();

        try {
           
            Scanner fileScanner = new Scanner(new File(filePath));
            StringBuilder jsonContent = new StringBuilder();
            while (fileScanner.hasNextLine()) {
                jsonContent.append(fileScanner.nextLine());
            }
            fileScanner.close();

            JSONObject jsonObject = new JSONObject(jsonContent.toString());

            String name = jsonObject.has("name") ? jsonObject.getString("name") : "N/A";
            String email = jsonObject.has("email") ? jsonObject.getString("email") : "N/A";

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (Exception e) {
            System.out.println("Error reading JSON: " + e.getMessage());
        }
    }
}
