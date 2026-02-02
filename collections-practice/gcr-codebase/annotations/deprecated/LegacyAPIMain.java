public class LegacyAPIMain {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        api.oldFeature(); // For this compiler will show an error
        api.newFeature();
    }
}
