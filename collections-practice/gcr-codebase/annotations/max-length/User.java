import java.lang.reflect.Field;

public class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        validate(username);
        this.username = username;
    }

    // Validation using Reflection
    private void validate(String username) {
        try {
            Field field = this.getClass().getDeclaredField("username");
            MaxLength maxLength = field.getAnnotation(MaxLength.class);

            if(maxLength != null && username.length() > maxLength.value()) {
                throw new IllegalArgumentException("Username length must be <= " + maxLength.value());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}

