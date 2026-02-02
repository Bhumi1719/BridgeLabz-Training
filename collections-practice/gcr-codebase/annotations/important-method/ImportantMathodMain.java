import java.lang.reflect.Method;

public class ImportantMathodMain {
    public static void main(String[] args) {

        Method[] methods = Service.class.getDeclaredMethods();

        System.out.println("Important Methods:");
        for(Method method : methods) {
            if(method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod im = method.getAnnotation(ImportantMethod.class);

                System.out.println(
                        "Method: " + method.getName() +
                        ", Level: " + im.level()
                );
            }
        }
    }
}
