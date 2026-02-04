import java.io.Serializable;

public class Employee implements BackUpSerializable, Serializable {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}