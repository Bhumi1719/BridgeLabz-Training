import java.util.*;

public class VisaCard {
    public static boolean isValidCard(String cardNumber) {

        // Visa starts with 4, exactly 16 digits
        String visaRegex = "^4\\d{15}$";

        // MasterCard starts with 5, exactly 16 digits
        String masterRegex = "^5\\d{15}$";

        return cardNumber.matches(visaRegex) || cardNumber.matches(masterRegex);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the card number: ");
        String card = sc.nextLine();

        System.out.print("Is the card number valid? " + isValidCard(card));
    }
}
