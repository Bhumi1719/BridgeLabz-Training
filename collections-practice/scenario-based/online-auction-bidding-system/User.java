public class User implements Comparable<User> {

    private int userId;
    private String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    // Needed for TreeMap sorting
    @Override
    public int compareTo(User other) {
        return this.userId - other.userId;
    }

    @Override
    public String toString() {
        return name + " (ID: " + userId + ")";
    }
}
