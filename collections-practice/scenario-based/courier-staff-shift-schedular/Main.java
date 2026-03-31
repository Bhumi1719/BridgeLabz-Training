import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CourierShiftScheduler scheduler = new CourierShiftScheduler();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<n; i++) {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            scheduler.addEmployee(new Employee(id, name));
        }

        System.out.print("How many employees to assign shift? ");
        int count = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<count; i++) {

            System.out.print("Enter Employee ID: ");
            int assignId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Shift (MORNING/AFTERNOON/EVENING): ");
            String shiftInput = sc.nextLine();

            Employee emp = scheduler.getEmployeeById(assignId);

            if(emp == null) {
                System.out.println("Employee not found!");
                continue;
            }

            try {
                scheduler.assignShift(emp, ShiftTime.valueOf(shiftInput.toUpperCase()));
                System.out.println("Shift assigned successfully.");
            } 
            catch (ShiftAlreadyAssignedException e) {
                System.out.println("Error: " + e.getMessage());
            } 
            catch (IllegalArgumentException e) {
                System.out.println("Invalid shift entered!");
            }
        }

        System.out.println("\nFinal Shift Allocation:");
        scheduler.displayShifts();

    }
}
