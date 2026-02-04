package problems;

import org.json.JSONObject;
import org.json.XML;
import java.util.Scanner;

public class JSONToXML {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter JSON string (e.g., {\"name\":\"Bhumi\",\"age\":20}):");
        String jsonString = sc.nextLine();

        try {
         
            JSONObject jsonObject = new JSONObject(jsonString);

            // Converting JSON to XML
            String xml = XML.toString(jsonObject);

            System.out.println("\nConverted XML:");
            System.out.println(xml);

        } catch (Exception e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}

