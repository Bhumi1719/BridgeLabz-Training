import java.util.TreeMap;

public class AuctionItem {

    private String itemName;
    private TreeMap<User, Double> bids = new TreeMap<>();

    private double highestBid = 0;
    private User highestBidder = null;

    public AuctionItem(String itemName) {
        this.itemName = itemName;
    }

    public void placeBid(Bid bid) throws InvalidBidException {

        if(bid.getAmount() <= highestBid) {
            throw new InvalidBidException("Bid must be higher than current highest bid: " + highestBid);
        }

        bids.put(bid.getUser(), bid.getAmount());

        highestBid = bid.getAmount();
        highestBidder = bid.getUser();

        System.out.println("Bid placed successfully!");
    }

    public void showHighestBid() {

        if(highestBidder == null) {
            System.out.println("No bids yet.");
            return;
        }

        System.out.println("\nHighest Bid Details:");
        System.out.println("Item: " + itemName);
        System.out.println("Bidder: " + highestBidder.getName());
        System.out.println("Amount: $" + highestBid);
    }
}
