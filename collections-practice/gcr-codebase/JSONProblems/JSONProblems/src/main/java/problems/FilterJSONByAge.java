package problems;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Scanner;

public class FilterJSONByAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter JSON array of students (e.g., [{\"name\":\"Bhumi\",\"age\":20}, {\"name\":\"Bhumika\",\"age\":30}]):");
        String jsonArrayStr = sc.nextLine();

        JSONArray studentsArray = new JSONArray(jsonArrayStr);

        // Filtering records where age > 25
        JSONArray filteredArray = new JSONArray();
        
        for(int i=0; i<studentsArray.length(); i++) {
            JSONObject student = studentsArray.getJSONObject(i);
            
            if(student.has("age") && student.getInt("age") > 25) {
                filteredArray.put(student);
            }
        }

        System.out.println("\nFiltered JSON (age > 25):");
        System.out.println(filteredArray.toString());
    }
}

