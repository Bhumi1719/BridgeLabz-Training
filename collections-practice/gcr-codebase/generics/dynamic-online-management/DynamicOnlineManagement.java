import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicOnlineManagement {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product<? extends Category>> catalog = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Add Clothing");
            System.out.println("3. Add Gadget");
            System.out.println("4. Apply Discount");
            System.out.println("5. Display Catalog");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1 :
                    System.out.print("Enter book name: ");
                    String bName = sc.nextLine();
                    System.out.print("Enter price: ");
                    double bPrice = sc.nextDouble();
                    catalog.add(new Product<>(bName, bPrice, new BookCategory()));
                    break;

                case 2 :
                    System.out.print("Enter clothing name: ");
                    String cName = sc.nextLine();
                    System.out.print("Enter price: ");
                    double cPrice = sc.nextDouble();
                    catalog.add(new Product<>(cName, cPrice, new ClothingCategory()));
                    break;

                case 3 :
                    System.out.print("Enter gadget name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    catalog.add(new Product<>(name, price, new GadgetCategory()));
                    break;

                case 4 :
                    System.out.print("Enter product index (starting from 0): ");
                    int index = sc.nextInt();
                    System.out.print("Enter discount %: ");
                    double percent = sc.nextDouble();
                    try {
                        Product<? extends Category> p = catalog.get(index);
                        DiscountUtil.applyDiscount(p, percent);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 5 :
                    for(int i=0; i<catalog.size(); i++) {
                        Product<? extends Category> p = catalog.get(i);
                        System.out.println(i + ". " + p.getName() + " | " + p.getCategory().getCategoryName()  + " | Price: " + p.getPrice());
                    }
                    break;
                    
                case 6 :
                    System.out.println("Exited");
                    sc.close();
                    return;
                
                default :
                    System.out.println("Invalid choice!");
            }
        }
    }
}
