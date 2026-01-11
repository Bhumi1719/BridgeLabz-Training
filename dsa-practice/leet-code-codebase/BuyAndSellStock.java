import java.util.*;

public class BuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int BUY = prices[0] ;
        int MAX_PROFIT = 0 ;

        for(int i=0; i<prices.length ; i++){

            if(prices[i] < BUY){
                BUY = prices[i] ;
            }

            MAX_PROFIT = Math.max(prices[i] - BUY , MAX_PROFIT);
        }

        return MAX_PROFIT ;
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