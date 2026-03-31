import java.util.*;

public class PriceOfItem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the price of the item ");
        double price = sc.nextInt();
        
        System.out.println("Enter the quantity to be bought ");
        int quantity = sc.nextInt();

        // Calculate the total price of the item
        double totalPrice = price * quantity;

        System.out.println("The total price is INR " + totalPrice + " if the quantity bought is " + quantity + " and the price of one item is INR " + price);
    }
}