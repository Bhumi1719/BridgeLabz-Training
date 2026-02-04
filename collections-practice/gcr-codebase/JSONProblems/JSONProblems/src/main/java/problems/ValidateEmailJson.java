package problems;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidateEmailJson {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            
            System.out.print("Enter JSON file path: ");
            String filePath = sc.nextLine();

            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line;
            
            while((line = br.readLine()) != null) {
                sb.append(line);
            }
            
            br.close();

            JSONObject jsonData = new JSONObject(new JSONTokener(sb.toString()));

            // Checking if email field exists
            if(!jsonData.has("email")) {
                System.out.println("Email field is missing");
                return;
            }

            String email = jsonData.getString("email");

            // Validating email using regex
            String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(email);

            if(matcher.matches()) {
                System.out.println("Email is valid: " + email);
            } else {
                System.out.println("Email is invalid: " + email);
            }

        } catch (Exception e) {
            System.out.println("Error reading or parsing the JSON file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
