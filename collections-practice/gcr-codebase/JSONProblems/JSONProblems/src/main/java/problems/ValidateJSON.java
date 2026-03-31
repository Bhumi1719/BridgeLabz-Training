package problems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Scanner;

public class ValidateJSON {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter JSON string to validate:");
        String jsonInput = sc.nextLine();

        ObjectMapper mapper = new ObjectMapper();
        try {
            // Parse JSON
            JsonNode node = mapper.readTree(jsonInput);
            System.out.println("Valid JSON!");
        } catch (Exception e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}
