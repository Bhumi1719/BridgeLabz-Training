import java.util.List;

public class WareHouseUtil {
    // Wildcard method
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getName() + " - " + item.getCategory());
        }
    }
}
