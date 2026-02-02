import java.lang.reflect.Field;

public class JSONRepresent {
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder();
        json.append("{");

        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();

        for(int i=0; i<fields.length; i++) {
            try {
                Field field = fields[i];
                field.setAccessible(true);

                json.append("\"")
                    .append(field.getName())
                    .append("\": ");

                Object value = field.get(obj);

                if(value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }

                if(i < fields.length - 1) {
                    json.append(", ");
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        json.append("}");
        return json.toString();
    }
}
