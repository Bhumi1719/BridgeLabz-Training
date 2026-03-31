import java.lang.reflect.Method;
import java.util.Scanner;

public class RoleAllowedMain {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your role: ");
        String currentUserRole = sc.nextLine(); 

        AdminService service = new AdminService();
        Class<?> clazz = service.getClass();

        if(clazz.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = clazz.getAnnotation(RoleAllowed.class);

            if(!roleAllowed.value().equalsIgnoreCase(currentUserRole)) {
                System.out.println("Access Denied!");
                sc.close();
                return;
            }
        }

        Method method = clazz.getMethod("deleteUser");
        method.invoke(service);

    }
}
