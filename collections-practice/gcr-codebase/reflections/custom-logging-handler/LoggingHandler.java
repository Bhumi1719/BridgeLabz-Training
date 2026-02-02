import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class LoggingHandler implements InvocationHandler {

    private final Object target;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("[LOG] Method called: " + method.getName());

        return method.invoke(target, args);
    }
}
