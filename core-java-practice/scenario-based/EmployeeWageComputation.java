import java.util.*;

public class EmployeeWageComputation {
    public static void main(String[] args) {

        Random random = new Random(); // Creating an object of random to display whether the employee is present or not randomly

        int WAGE_PER_HOUR = 20; // Wage for each hour in a day is 20
        int HOURS_FULL_DAY = 8; // The employee has to work 8 hours daily
        int HOURS_PART_TIME = 4; // For part-time the employee has to work 4 hours daily

        int TOTAL_DAYS = 0; // Variable to track the total days of the month
        int TOTAL_HOURS = 0; // Variable to track the total hours 
        int TOTAL_WAGE = 0; // Variable to store the total wage
        int PRESENT_DAYS = 0; // Variable for the present days

        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");

        // Loop to execute the process till the condition satisfies
        while(TOTAL_DAYS < 20 && TOTAL_HOURS < 100) {

            TOTAL_DAYS ++; // Increamenting the days each time loop is executed

            System.out.println("\nDay " + TOTAL_DAYS + ": ");

            boolean isPresent = random.nextBoolean(); // Generating random guess for present or absent

            int WORKING_HOURS = 0; // Variable to store working hours
            int DAILY_WAGE = 0; // Variable to store wage of employee on daily basis

            // Condition if the employee is present(UC -1)
            if(isPresent) {
                PRESENT_DAYS ++;
                System.out.println("Employee is present today!");

                int jobType = random.nextInt(2); // Generating a random guess for full-time and part-time

                // Switch case for the job type(UC-3 and UC-4)
                switch(jobType) { 
                    case 0 : // For part-time work
                        WORKING_HOURS += HOURS_PART_TIME;
                        System.out.println("Employee is part-time");
                        break;

                    case 1 : // For full-time work
                        WORKING_HOURS += HOURS_FULL_DAY;
                        System.out.println("Employee is full-time");
                        break;

                }
            } else { // Condition if employee is absent
                WORKING_HOURS = 0;
                System.out.println("Employee is absent today!");
            }

            // (UC-2)
            DAILY_WAGE = WORKING_HOURS * WAGE_PER_HOUR; // Calculating the daily wage of the employee based on the two conditions: part-time or full-time
            System.out.println("Daily Wage is INR " + DAILY_WAGE); // Displaying the daily wage for each day
            TOTAL_HOURS += WORKING_HOURS; // Adding the working hours in total working hours as per condition
            TOTAL_WAGE += DAILY_WAGE; // Adding the wage of the employee he earned daily in total wage
        }
        
        // (UC-5 and UC-6)
        System.out.println("\nTotal Working days is: " + PRESENT_DAYS); // Dispalying the total working days of employee
        System.out.println("Total Working hours is: " + TOTAL_HOURS); // Displaying the toatl workig hours of employee in a month
        System.out.println("Total wage of the employee is INR " + TOTAL_WAGE); // Displaying the total wage the employee gets
    }
}