public class ProfitLossPercent {
    public static void main(String[] args) {
        int COST_PRICE = 129;
        int SELL_PRICE = 191;

        // Calculate profit or loss
        int profit = SELL_PRICE - COST_PRICE;
        double profitPercent = (profit / (double)COST_PRICE) * 100;

        System.out.println("The Cost Price is INR " + COST_PRICE + " and Selling Price is INR " + SELL_PRICE + "\nThe Profit is INR " + profit + " and the Profit Percentage is " + String.format("%.2f", profitPercent) + "%");
    }
}