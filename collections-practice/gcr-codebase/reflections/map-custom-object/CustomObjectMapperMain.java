import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomObjectMapperMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Object> data = new HashMap<>();

        System.out.println("\nEnter student details: ");
        System.out.print("Enter ID: ");
        data.put("id", sc.nextInt());
        sc.nextLine();

        System.out.print("Enter Name: ");
        data.put("name", sc.nextLine());

        System.out.print("Enter Age: ");
        data.put("age", sc.nextInt());

        Student student = CustomObjectMapper.toObject(Student.class, data);
        student.display();

        sc.close();
    }
}
