import java.util.*;

public class GroupEmployeesByDepartment {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            System.out.print("Enter employee name: ");
            String name = sc.next();

            System.out.print("Enter department: ");
            String department = sc.next();

            employees.add(new Employee(name, department));
        }

        Map<String, List<Employee>> deptMap = new HashMap<>();

        for(Employee emp : employees) {
            deptMap.computeIfAbsent(emp.department, k -> new ArrayList<>()).add(emp);
        }

        System.out.println("\nEmployees Grouped by Department:");
        for(Map.Entry<String, List<Employee>> entry : deptMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}
