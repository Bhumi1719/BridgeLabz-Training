import java.util.*;

public class EmployeeWageBuilder implements IEmployeeWageBuilder {

    private ArrayList<CompanyEmpWage> companyList;
    private HashMap<String, CompanyEmpWage> companyMap;

    private static final int FULL_TIME_HOURS = 8;
    private static final int PART_TIME_HOURS = 4;

    EmployeeWageBuilder() {
        companyList = new ArrayList<>();
        companyMap = new HashMap<>();
    }

    // Methdo to add Company
    public void addCompany(String companyName,int wagePerHour,int maxWorkingDays,int maxWorkingHours) {

        CompanyEmpWage company = new CompanyEmpWage(companyName, wagePerHour, maxWorkingDays, maxWorkingHours);

        companyList.add(company);
        companyMap.put(companyName, company);
    }

    // Method to compute Wage for All Companies
    public void computeEmployeeWage() {

        for(CompanyEmpWage company : companyList) {

            int totalWorkingDays = 0;
            int totalWorkingHours = 0;

            Random random = new Random();

            while(totalWorkingDays < company.getMaxWorkingDays() && totalWorkingHours < company.getMaxWorkingHours()) {

                totalWorkingDays++;

                int empCheck = random.nextInt(3);
                int workingHours = 0;

                switch (empCheck) {
                    case 1:
                        workingHours = PART_TIME_HOURS;
                        break;
                    case 2:
                        workingHours = FULL_TIME_HOURS;
                        break;
                    default:
                        workingHours = 0;
                }

                totalWorkingHours += workingHours;

                int dailyWage = workingHours * company.getWagePerHour();
                company.addDailyWage(dailyWage);
            }

            System.out.println("Company: " + company.getCompanyName());
            System.out.println("Daily Wages: " + company.getDailyWages());
            System.out.println("Total Monthly Wage: INR " + company.getTotalMonthlyWage());
            System.out.println("---------------------------------------");
        }
    }

    // Method to get Total Wage by Company Name
    public int getTotalWage(String companyName) {

        CompanyEmpWage company = companyMap.get(companyName);

        if(company != null) {
            return company.getTotalMonthlyWage();
        }

        System.out.println("Company Not Found!");
        return -1;
    }

    // Method to get Daily Wages by Company Name
    public ArrayList<Integer> getDailyWages(String companyName) {

        CompanyEmpWage company = companyMap.get(companyName);

        if(company != null) {
            return company.getDailyWages();
        }

        System.out.println("Company Not Found!");
        return new ArrayList<>();
    }
}