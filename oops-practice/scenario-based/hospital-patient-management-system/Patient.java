// Creating a class named Patient with attributes
public class Patient {
    protected int id;
    protected String name;
    protected int age;
    protected Doctor doctor;

    // Creating a constructor of the class
    public Patient(int id, String name, int age, Doctor doctor) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.doctor = doctor;
    }

    // Creating a method to display information(Polymorphism)
    public void displayInfo() { 
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
        System.out.println("Doctor: " + doctor.name + " (" + doctor.specialization + ")");
    }
}
