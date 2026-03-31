import java.util.*;

public class AmarAkbarAnthony {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the height of Amar ");
        double amarHeight = sc.nextDouble();
        System.out.print("Enter the height of Akbar ");
        double akbarHeight = sc.nextDouble();
        System.out.print("Enter the height of Anthony ");
        double anthonyHeight = sc.nextDouble();


        // Determining the tallest among three using if else conditionals
        if(amarHeight > akbarHeight && amarHeight > anthonyHeight) {
            System.out.println("Amar is the tallest among the three"); // If Amar's height is greater than both then this if block will execute
        } else if(akbarHeight > amarHeight && akbarHeight > anthonyHeight) {
            System.out.println("Akbar is the tallest among the three"); // If Akbar's height is greater than both then this else if block will execute
        } else{
            System.out.println("Anthony is the tallest among the three"); // If none of the above conditions match then this else block will execute
        }


        System.out.print("Enter the age of Amar ");
        int amanAge = sc.nextInt();
        System.out.print("Enter the age of Akbar ");
        int akbarAge = sc.nextInt();
        System.out.print("Enter the age of Anthony ");
        int anthonyAge = sc.nextInt();

        // Determining the youngest among three using if else conditionals
        if(amanAge < akbarAge && amanAge < anthonyAge) {
            System.out.println("Amar is the youngest among the three"); // If Amar's age is less than both then this if statement will execute
        } else if(akbarAge < amanAge && akbarAge < anthonyAge) {
            System.out.println("Akbar is the youngest among the three"); // If Akbar's age is less than both then this else if statement will execute
        } else{
            System.out.println("Anthony is the youngest among the three"); // If none of the above conditions match then this else statement will execute
        }
    }
}