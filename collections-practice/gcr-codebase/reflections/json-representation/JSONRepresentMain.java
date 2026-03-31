import java.lang.reflect.Field;
import java.util.Scanner;

public class JSONRepresentMain {
        public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentInfo student = new StudentInfo();

        try {
            Class<?> cls = student.getClass();
            Field[] fields = cls.getDeclaredFields();

            System.out.println("Enter the student details: ");
            for(Field field : fields) {
                field.setAccessible(true);
                System.out.print("Enter " + field.getName() + ": ");

                if(field.getType() == int.class) {
                    field.set(student, sc.nextInt());
                    sc.nextLine(); 
                } else if (field.getType() == String.class) {
                    field.set(student, sc.nextLine());
                }
            }

            // Converting to JSON
            String json = JSONRepresent.toJson(student);
            System.out.println("JSON Representation: " + json);

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
