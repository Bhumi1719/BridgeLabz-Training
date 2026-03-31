import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {

    private List<Employee> employees = new ArrayList<>();

    // Method to add employee to the list
    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    // Method to serialize the employee list to a file
    public void saveToFile(String filePath) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(employees);
            System.out.println("Employee list saved successfully to " + filePath);
        } catch(IOException e) {
            System.out.println("Error saving employee data.");
            e.printStackTrace();
        }
    }

    // Method to deserialize employee list from a file
    public void loadFromFile(String filePath) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Employee list loaded successfully from " + filePath);
        } catch(IOException | ClassNotFoundException e) {
            System.out.println("Error loading employee data.");
            e.printStackTrace();
        }
    }

    // Method to display all employees
    public void displayEmployees() {
        if(employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("\nEmployee List:");
            for(Employee emp : employees) {
                System.out.println(emp);
            }
        }
    }
}
