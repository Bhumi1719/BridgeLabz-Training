import java.util.Random;

class EmployeeBonus {
    public static void main(String[] args) {

        int employees = 10;

        double[][] employeeDetails = employeeDataGeneration(employees); // Calling the method to generate details of employees

        double[][] bonus = findBonus(employeeDetails); // Calling the method to find the bonus

        printReport(employeeDetails, bonus); // Calling the method to display the report of the employee
    }

    // Method to generate salary and years of service of 10 employees
    public static double[][] employeeDataGeneration(int employees) {

        // Creating an array to store the data of employees
        double[][] data = new double[employees][2];
        Random random = new Random(); // Creating an object of random

        // Loop to generate the employees data
        for(int i=0; i<employees; i++) {
            data[i][0] = 10000 + random.nextInt(90000); // 5-digit salary
            data[i][1] = 1 + random.nextInt(10);       // 1–10 years service
        }

        return data; // Returning the array with employees data
    }

    // Method to calculate new salary and bonus
    public static double[][] findBonus(double[][] data) {
        // Creatingan array to store the bonus, new salary and old salary of the employees
        double[][] result = new double[data.length][3];

        for(int i=0; i<data.length; i++) {
            double salary = data[i][0]; // Storing the old salary of employee
            int years = (int) data[i][1]; // Storing the year of service of the employee

            double bonusRate = (years > 5) ? 0.05 : 0.02; // Calculating the bonus rate using ternary operator
            double bonus = salary * bonusRate; // Calculating bonus of the employee
            double newSalary = salary + bonus; // Calculating the new salary of the employee 

            result[i][0] = salary; // Old salary
            result[i][1] = bonus; // Bonus
            result[i][2] = newSalary; // New salary
        }

        return result; // Returning the array with the data
    }

    // Method to calculate totals and print result
    public static void printReport(double[][] data, double[][] result) {

        // Variables to store the result
        double TOTAL_OLD_SALARY = 0;
        double TOTAL_BONUS = 0;
        double TOTAL_NEW_SALARY = 0;

        System.out.println("Emp\tOldSalary\tYears\tBonus\tNewSalary");
        System.out.println(); // For extra line

        // Storing the result
        for(int i=0; i<data.length; i++) {
            TOTAL_OLD_SALARY += result[i][0];
            TOTAL_BONUS += result[i][1];
            TOTAL_NEW_SALARY += result[i][2];

            System.out.println((i + 1) + "\t" + String.format("%.2f", result[i][0]) + "\t" + (int) data[i][1] + "\t" + String.format("%.2f", result[i][1]) + "  " + String.format("%.2f", result[i][2]));
        }
        System.out.println(); // For extra line
        System.out.println("TOTAL\t" + TOTAL_OLD_SALARY + "\t\t" + String.format("%.2f", TOTAL_BONUS) + " " + String.format("%.2f", TOTAL_NEW_SALARY));
    }
}
