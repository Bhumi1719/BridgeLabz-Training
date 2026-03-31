public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome To Employee Wage Computation Program\n");

        IEmployeeWageBuilder builder = new EmployeeWageBuilder();

        builder.addCompany("TCS", 20, 20, 100);
        builder.addCompany("Infosys", 25, 22, 110);
        builder.addCompany("Wipro", 18, 20, 90);

        builder.computeEmployeeWage();

        System.out.println("\nTCS Daily Wages: " + builder.getDailyWages("TCS"));

        System.out.println("TCS Total Wage: INR " + builder.getTotalWage("TCS"));
    }
}