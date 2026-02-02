import java.lang.reflect.Field;
import java.util.Scanner;

public class StaticFieldsModification {
        public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Displaying before modification
            Configuration.printKey();

            System.out.print("Enter new API KEY: ");
            String newKey = sc.nextLine();

            // Loading class
            Class<?> cls = Configuration.class;

            Field field = cls.getDeclaredField("API_KEY");
            field.setAccessible(true);

            // Modifying static field
            field.set(null, newKey);

            // Displaying after modification
            Configuration.printKey();

            // Retrieving value via reflection
            System.out.println("\nRetrieved via Reflection: " + field.get(null));

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
