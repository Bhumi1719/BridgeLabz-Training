package problems;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StudentField {
    private String name;
    private int age;

    public StudentField(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class ListToJSONArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        List<StudentField> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for(int i=0; i<n; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine(); 

            students.add(new StudentField(name, age));
        }

        // Converting list of students to JSON array
        JSONArray jsonArray = new JSONArray();
        
        for(StudentField s : students) {
            JSONObject obj = new JSONObject();
            obj.put("name", s.getName());
            obj.put("age", s.getAge());
            jsonArray.put(obj);
        }

        System.out.println("\nJSON Array:");
        System.out.println(jsonArray.toString()); 
    }
}

