import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeRole {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        while (true) {
            System.out.print("\nEnter role (Manager/Developer) or 'exit' to finish: ");
            String role = sc.next();

            if (role.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter name: ");
            String name = sc.next();

            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();

            Employee emp;
            if(role.equalsIgnoreCase("Manager")) {
                emp = new Manager(name, salary);
            } else if(role.equalsIgnoreCase("Developer")) {
                emp = new Developer(name, salary);
            } else {
                System.out.println("Invalid role! Try again.");
                continue;
            }

            employees.add(emp);
            
            for(Employee empl : employees) {
            System.out.printf("\n%s (%s) - Bonus: %.2f%n", empl.getName(),
                    empl instanceof Manager ? "Manager" : "Developer",
                    empl.getBonus());
        }
        }
    }
}
