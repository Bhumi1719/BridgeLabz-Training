import java.lang.reflect.Method;
import java.util.Scanner;

public class CustomException {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        TaskManager manager = new TaskManager();

        Method[] methods = manager.getClass().getDeclaredMethods();

        System.out.println("Available Tasks:");
        for(int i=0; i<methods.length; i++) {
            if(methods[i].isAnnotationPresent(TaskInfo.class)) {
                System.out.println((i + 1) + ". " + methods[i].getName());
            }
        }

        System.out.print("\nEnter task number to execute: ");
        int choice = sc.nextInt();

        Method selectedMethod = methods[choice - 1];
        TaskInfo info = selectedMethod.getAnnotation(TaskInfo.class);

        System.out.println("\nTask Details:");
        System.out.println("Priority: " + info.priority());
        System.out.println("Assigned To: " + info.assignedTo());

        selectedMethod.invoke(manager);
    }
}
