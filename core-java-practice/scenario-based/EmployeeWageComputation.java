import java.util.*;

public class EmployeeWageComputation {
    public static void main(String[] args) {

        Random random = new Random(); // Creating an object of random to display whether the employee is present or not randomly

        final int WAGE_PER_HOUR = 20; // Wage for each hour in a day is 20
        final int HOURS_FULL_DAY = 8; // The employee has to work 8 hours daily
        final int HOURS_PART_TIME = 4; // For part-time the employee has to work 4 hours daily

        int totalDays = 0; // Variable to track the total days of the month
        int totalHours = 0; // Variable to track the total hours 
        int totalWage = 0; // Variable to store the total wage
        int presentDays = 0; // Variable for the present days

        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");

        // Loop to execute the process till the condition satisfies
        while(totalDays < 20 && totalHours <= 100) {

            totalDays ++; // Increamenting the days each time loop is executed

            System.out.println("\nDay " + totalDays + ": ");

            boolean isPresent = random.nextBoolean(); // Generating random guess for present or absent

            int workingHours = 0; // Variable to store working hours
            int dailyWage = 0; // Variable to store wage of employee on daily basis

            // Condition if the employee is present(UC -1)
            if(isPresent) {
                presentDays ++;
                System.out.println("Employee is present today!");

                int jobType = random.nextInt(2); // Generating a random guess for full-time and part-time

                // Switch case for the job type(UC-3 and UC-4)
                switch(jobType) { 
                    case 0 : // For part-time work
                        workingHours += HOURS_PART_TIME;
                        System.out.println("Employee is part-time");
                        break;

                    case 1 : // For full-time work
                        workingHours += HOURS_FULL_DAY;
                        System.out.println("Employee is full-time");
                        break;

                }
            } else { // Condition if employee is absent
                workingHours = 0;
                System.out.println("Employee is absent today!");
            }

            // (UC-2)
            dailyWage = workingHours * WAGE_PER_HOUR; // Calculating the daily wage of the employee based on the two conditions: part-time or full-time
            System.out.println("Daily Wage is INR " + dailyWage); // Displaying the daily wage for each day
            totalHours += workingHours; // Adding the working hours in total working hours as per condition
            totalWage += dailyWage; // Adding the wage of the employee he earned daily in total wage
        }
        
        // (UC-5 and UC-6)
        System.out.println("\nTotal Working days is: " + presentDays); // Dispalying the total working days of employee
        System.out.println("Total Working hours is: " + totalHours); // Displaying the toatl workig hours of employee in a month
        System.out.println("Total wage of the employee is INR " + totalWage); // Displaying the total wage the employee gets
    }
}