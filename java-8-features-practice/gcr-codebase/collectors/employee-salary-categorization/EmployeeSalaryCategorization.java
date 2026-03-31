import java.util.*;
import java.util.stream.Collectors;

public class EmployeeSalaryCategorization {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int number = sc.nextInt();
        sc.nextLine(); 

        for(int i=1; i<=number; i++) {

            System.out.println("\nEmployee " + i);

            System.out.print("Enter employee name: ");
            String name = sc.nextLine();

            System.out.print("Enter department: ");
            String dept = sc.nextLine();

            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            employees.add(new Employee(name, dept, salary));
        }

        // Calculating Average salary by department
        Map<String, Double> avgSalaryByDept = employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        ));

        System.out.println("\nAverage Salary By Department");

        avgSalaryByDept.forEach((dept, avgSalary) -> System.out.println(dept + " -> $" + avgSalary));
    }
}
