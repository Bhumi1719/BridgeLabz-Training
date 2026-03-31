public class User {
    private int userId;
    private String name;
    private Wallet wallet;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.wallet = new Wallet();
    }

    public int getUserId() { return userId; }
    public String getName() { return name; }
    public Wallet getWallet() { return wallet; }
}
