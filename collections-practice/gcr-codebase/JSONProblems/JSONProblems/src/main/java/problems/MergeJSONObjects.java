package problems;

import org.json.JSONObject;
import java.util.Scanner;

public class MergeJSONObjects {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first JSON object (e.g., {\"name\":\"Bhumi\",\"age\":20}):");
        String json1Str = sc.nextLine();
        JSONObject json1 = new JSONObject(json1Str);

        System.out.println("Enter second JSON object (e.g., {\"email\":\"bhumi@example.com\",\"city\":\"Delhi\"}):");
        String json2Str = sc.nextLine();
        JSONObject json2 = new JSONObject(json2Str);

        // Merging json2 into json1
        for(String key : json2.keySet()) {
            json1.put(key, json2.get(key));
        }

        System.out.println("\nMerged JSON:");
        System.out.println(json1.toString()); 
    }
}

