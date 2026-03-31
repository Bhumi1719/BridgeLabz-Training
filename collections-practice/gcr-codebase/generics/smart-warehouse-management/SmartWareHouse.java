import java.util.Scanner;

public class SmartWareHouse {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceryStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        while (true) {
            System.out.println("\n1. Add Electronics");
            System.out.println("2. Add Groceries");
            System.out.println("3. Add Furniture");
            System.out.println("4. Display All Items");
            System.out.println("5. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch(choice) {
                case 1 :
                    System.out.print("Enter electronics name: ");
                    String eName = sc.nextLine();
                    electronicsStorage.addItem(new Electronics(eName));
                    System.out.println("Electronics item added.");
                    break;

                case 2 :
                    System.out.print("Enter grocery name: ");
                    String gName = sc.nextLine();
                    groceryStorage.addItem(new Groceries(gName));
                    System.out.println("Grocery item added.");
                    break;

                case 3 :
                    System.out.print("Enter furniture name: ");
                    String fName = sc.nextLine();
                    furnitureStorage.addItem(new Furniture(fName));
                    System.out.println("Furniture item added.");
                    break;
                
                case 4 :
                    System.out.println("\nElectronics:");
                    WareHouseUtil.displayItems(electronicsStorage.getAllItems());
                    System.out.println("\nGroceries:");
                    WareHouseUtil.displayItems(groceryStorage.getAllItems());
                    System.out.println("\nFurniture:");
                    WareHouseUtil.displayItems(furnitureStorage.getAllItems());
                    break;

                case 5 :
                    System.out.println("Exited");
                    sc.close();
                    return;
                
                default :
                    System.out.println("Invalid choice!");
            }
        }
    }
}
