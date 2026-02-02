import java.lang.reflect.Field;

class DIContainer {

    // Injecting dependencies annotated with @Inject
    public static <T> T createInstance(Class<T> clazz) {
        
        try {
            T obj = clazz.getDeclaredConstructor().newInstance();

            for(Field field : clazz.getDeclaredFields()) {
                if(field.isAnnotationPresent(Inject.class)) {
                    field.setAccessible(true);

                    // Creating instance of the dependency recursively
                    Object dependency = createInstance(field.getType());

                    field.set(obj, dependency);
                }
            }
            return obj;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
