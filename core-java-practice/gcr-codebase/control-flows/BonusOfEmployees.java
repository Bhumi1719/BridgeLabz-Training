import java.util.*;

public class BonusOfEmployees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the years of service of the employees ");
        int yearOfService = sc.nextInt();

        System.out.print("Enter the salary of employee is ");
        double salary = sc.nextDouble();

        if(yearOfService > 5) {
            double bonus = salary * 0.05; // 5% bonus for years of service more than 5
            System.out.println("The bonus for the employee is " + bonus);
        }else{
            System.out.println("Bonus is 0");
        }
    }
}