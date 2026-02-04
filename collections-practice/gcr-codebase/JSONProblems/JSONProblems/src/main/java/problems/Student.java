package problems;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Scanner;

public class Student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter student age: ");
        int age = sc.nextInt();
        sc.nextLine();

        JSONArray subjects = new JSONArray();
        System.out.println("Enter subjects (type 'done' to finish):");
        while(true) {
            String subject = sc.nextLine();
            if(subject.equalsIgnoreCase("done")) {
                break;
            }
            subjects.put(subject);
        }

        // Creating JSON object
        JSONObject student = new JSONObject();
        student.put("name", name);
        student.put("age", age);
        student.put("subjects", subjects);

        System.out.println("\nStudent JSON:");
        System.out.println("{");
        System.out.println("  \"name\": \"" + student.getString("name") + "\",");
        System.out.println("  \"age\": " + student.getInt("age") + ",");
        System.out.println("  \"subjects\": " + student.getJSONArray("subjects").toString());
        System.out.println("}");
    }
}

