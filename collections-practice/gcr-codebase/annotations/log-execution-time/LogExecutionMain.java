import java.lang.reflect.Method;

public class LogExecutionMain {
    public static void main(String[] args) throws Exception {

        PerformanceTest test = new PerformanceTest();
        Method[] methods = PerformanceTest.class.getDeclaredMethods();

        for(Method method : methods) {
            if(method.isAnnotationPresent(LogExecutionTime.class)) {

                long startTime = System.nanoTime();
                method.invoke(test);
                long endTime = System.nanoTime();

                System.out.println(
                        method.getName() + " executed in " +
                        (endTime - startTime) + " ns"
                );
            }
        }
    }
}
