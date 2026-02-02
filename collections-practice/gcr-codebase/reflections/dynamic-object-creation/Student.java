public class Student {
    private int id;
    private String name;

    public Student() {
        this.id = 0;
        this.name = "Unknown";
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}
