import java.lang.reflect.Field;
import java.util.Map;

public class CustomObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            
            // Creating object dynamically
            T obj = clazz.getDeclaredConstructor().newInstance();

            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                try {
                    Field field = clazz.getDeclaredField(entry.getKey());
                    field.setAccessible(true);
                    field.set(obj, entry.getValue());
                } catch (NoSuchFieldException e) {
                    // Ignore if field does not exist
                }
            }
            return obj;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
