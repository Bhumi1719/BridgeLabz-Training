import java.util.*;

public interface IEmployeeWageBuilder {
    void addCompany(String companyName,int wagePerHour,int maxWorkingDays,int maxWorkingHours);
    void computeEmployeeWage();
    int getTotalWage(String companyName);
    ArrayList<Integer> getDailyWages(String companyName);
}