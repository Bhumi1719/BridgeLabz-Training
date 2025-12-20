import java.util.*;

public class EmployeeSalary {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Declaring array to store salary
        double[] salary = new double[10];

        // Declaring array to store years of service
        double[] yearsOfService = new double[10];

        // Declaring array to store bonus of employees
        double[] bonus = new double[10];

        // Declaring array to store salary after the bonus
        double[] newSalary = new double[10];

        double TOTAL_BONUS = 0.0;
        double TOTAL_OLD_SALARY = 0.0;
        double TOTAL_NEW_SALARY = 0.0;

        // Loop for taking input for 10 employees
        for (int i=0; i<10; i++) {
            System.out.print("Enter salary for employee " + (i + 1) + ": ");
            salary[i] = sc.nextDouble();

            System.out.print("Enter year of service for employee " + (i + 1) + ": ");
            yearsOfService[i] = sc.nextDouble();

            // Validation of input
            if (salary[i] <= 0 || yearsOfService[i] < 0) {
                System.out.println("Invalid input. Please enter again.");
                i--; // decrement index to re-enter data
            }
        }

        // Calculating bonus, new salary, and totals
        for (int i=0; i<10; i++) {
            if (yearsOfService[i] > 5) {
                bonus[i] = salary[i] * 0.05;
            } else{
                bonus[i] = salary[i] * 0.02;
            }

            newSalary[i] = salary[i] + bonus[i];

            TOTAL_BONUS += bonus[i];
            TOTAL_OLD_SALARY += salary[i];
            TOTAL_NEW_SALARY += newSalary[i];
        }

        System.out.println("Total Bonus Payout = " + TOTAL_BONUS);
        System.out.println("Total Old Salary = " + TOTAL_OLD_SALARY);
        System.out.println("Total New Salary = " + TOTAL_NEW_SALARY);
    }
}
