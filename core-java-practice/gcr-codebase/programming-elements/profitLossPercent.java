public class profitLossPercent {
    public static void main(String[] args) {
        int costPrice = 129;
        int sellPrice = 191;

        // Calculate profit or loss
        int profit = sellPrice - costPrice;
        double profitPercent = (profit / (double)costPrice) * 100;

        System.out.println("The Cost Price is INR " + costPrice + " and Selling Price is INR " + sellPrice + "\nThe Profit is INR " + profit + " and the Profit Percentage is " + String.format("%.2f", profitPercent) + "%");
    }
}