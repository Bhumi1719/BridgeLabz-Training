import java.lang.reflect.Field;
import java.util.Scanner;

public class AccessPrivateField {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter age: ");
            int inputAge = sc.nextInt();

            // Creating an object of the Person class
            Person p = new Person(inputAge);

            Class<?> cls = p.getClass();
            Field ageField = cls.getDeclaredField("age");
            ageField.setAccessible(true);

            // Getting original value
            System.out.println("Original Age is: " + ageField.get(p));

            // Modifying age using reflection
            System.out.print("Enter new age to set using reflection: ");
            int newAge = sc.nextInt();
            ageField.set(p, newAge);

            // Getting updated value
            System.out.println("Updated Age is: " + ageField.get(p));

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}

