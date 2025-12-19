public class UniversityAmount {
    public static void main(String[] args) {
        int FEE = 125000;
        int DISCOUNT_PERCENT = 10;;

        // Calculate the discounted amount
        int discount = (FEE * DISCOUNT_PERCENT) / 100;

        // Calculate the fee after discount
        int discountFee = (FEE - DISCOUNT_PERCENT);

        System.out.println("The discount amount is INR " + discount + " and the final discounted fee is INR " + discountFee);
    }
}