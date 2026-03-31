import java.util.*;

public class CompanyEmpWage {

    private String companyName;
    private int wagePerHour;
    private int maxWorkingDays;
    private int maxWorkingHours;
    private int totalMonthlyWage;
    private ArrayList<Integer> dailyWages;

    CompanyEmpWage(String companyName,int wagePerHour,int maxWorkingDays,int maxWorkingHours) {

        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
        this.dailyWages = new ArrayList<>();
        this.totalMonthlyWage = 0;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getWagePerHour() {
        return wagePerHour;
    }

    public int getMaxWorkingDays() {
        return maxWorkingDays;
    }

    public int getMaxWorkingHours() {
        return maxWorkingHours;
    }

    public int getTotalMonthlyWage() {
        return totalMonthlyWage;
    }

    public ArrayList<Integer> getDailyWages() {
        return dailyWages;
    }

    public void addDailyWage(int dailyWage) {
        dailyWages.add(dailyWage);
        totalMonthlyWage += dailyWage;
    }
}
