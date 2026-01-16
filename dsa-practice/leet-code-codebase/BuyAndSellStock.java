import java.util.*;

public class BuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int buy = prices[0] ;
        int maxProfit = 0 ;

        for(int i=0; i<prices.length ; i++){

            if(prices[i] < buy){
                buy = prices[i] ;
            }

            maxProfit = Math.max(prices[i] - buy , maxProfit);
        }

        return maxProfit ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of days: ");
        int days = sc.nextInt();

        int[] prices = new int[days];

        System.out.print("Enter stock prices for each day:");
        for(int i=0; i<days; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.print("Maximum Profit: " + maxProfit(prices));
    }
}