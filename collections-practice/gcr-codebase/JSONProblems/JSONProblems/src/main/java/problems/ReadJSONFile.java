package problems;

import org.json.JSONObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class ReadJSONFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter JSON file path: ");
        String filePath = sc.nextLine();

        try {
           
            Scanner fileScanner = new Scanner(new File(filePath));
            
            StringBuilder jsonContent = new StringBuilder();
            
            while(fileScanner.hasNextLine()) {
                jsonContent.append(fileScanner.nextLine());
            }
            
            fileScanner.close();

            JSONObject jsonObject = new JSONObject(jsonContent.toString());

            System.out.println("\nKeys and Values:");
            
            Iterator<String> keys = jsonObject.keys();
            
            while(keys.hasNext()) {
                String key = keys.next();
                System.out.println(key + ": " + jsonObject.get(key));
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (Exception e) {
            System.out.println("Error reading JSON: " + e.getMessage());
        }
    }
}

