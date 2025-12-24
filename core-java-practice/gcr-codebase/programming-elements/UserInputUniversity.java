import java.util.*;

public class UserInputUniversity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the university fee: ");
        int fee = sc.nextInt();

        System.out.println("Enter the discount percentage: ");
        int discountPercent = sc.nextInt();

        // Calculate the discounted amount
        int discount = (fee * discountPercent) / 100;

        // Calculate the fee after discount
        int discountFee = fee - discount;

        System.out.println("The discount amount is INR " + discount + " and the final discounted fee is INR " + discountFee);
    }
}