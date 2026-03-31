package problems;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Scanner;

public class CSVToJSON {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of CSV rows (including header): ");
        int rows = sc.nextInt();
        sc.nextLine(); 

        if(rows < 2) {
            System.out.println("CSV must have at least one data row.");
            return;
        }

        String[] headers = null;
        JSONArray jsonArray = new JSONArray();

        for(int i=0; i<rows; i++) {
            System.out.println("Enter row " + (i + 1) + " (comma-separated):");
            String line = sc.nextLine();
            
            String[] values = line.split(",");

            if(i == 0) {
                headers = values;
            } else {
                // Creating JSON object for each row
                JSONObject obj = new JSONObject();
                
                for(int j=0; j<headers.length && j < values.length; j++) {
                    obj.put(headers[j].trim(), values[j].trim());
                }
                jsonArray.put(obj);
            }
        }

        System.out.println("\nConverted JSON:");
        System.out.println(jsonArray.toString());
    }
}
