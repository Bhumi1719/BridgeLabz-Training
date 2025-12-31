// Creating a class named as item with attributes in it
class Item {
	String itemCode;
	String itemName;
	double price;
	
	// Creating constructor of the class Item
	Item(String itemCode, double price, String itemName) {
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.price = price;
	}
	
	// Creating a method to display the details of items
	void displayDetails() {
		System.out.println("itemCode : " + itemCode);
		System.out.println("itemPrice : " + price);
		System.out.println("itemName : " + itemName);
		System.out.println("-------------------------"); 
	}
	
}
public class ItemInventory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Creating object of the class to call it for three different items
		Item item1 = new Item("01AA", 500, "Water Bottle");
		item1.displayDetails();
		
		Item item2 = new Item("01BB", 700, "Rice");
		item2.displayDetails();
		
		Item item3 = new Item("02AA", 400, "BlackBoard");
		item3.displayDetails();
		
	}

}
