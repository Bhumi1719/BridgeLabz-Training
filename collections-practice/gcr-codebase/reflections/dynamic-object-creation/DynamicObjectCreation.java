import java.lang.reflect.Constructor;
import java.util.Scanner;

public class DynamicObjectCreation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            // Loading class dynamically
            Class<?> cls = Class.forName("Student");

            // Getting parameterized constructor
            Constructor<?> constructor = cls.getConstructor(int.class, String.class);

            // Creating object dynamically without using new keyword
            Object obj = constructor.newInstance(id, name);

            Student s = (Student) obj;
            s.display();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
