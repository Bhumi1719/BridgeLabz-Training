import java.util.Scanner;

// Creating a node class to represent a single inventory item
class ItemNode {
    int itemId;           
    String itemName;      
    int quantity;         
    double price;         
    ItemNode next;      

    // Creating a cnstructor of the node class
    ItemNode(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

// Inventory linked list
class InventoryList {
    private ItemNode head;   // Head of the linked list

    // Creating a method to add item at beginning
    public void addAtBeginning(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = head;
        head = newNode;
    }

    // Creating a method to add item at end
    public void addAtEnd(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);

        if(head == null) {
            head = newNode;
            return;
        }

        ItemNode temp = head;
        while(temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }

    // Creating a method to add item at specific position (1-based index)
    public void addAtPosition(int pos, int id, String name, int qty, double price) {
        if(pos <= 1 || head == null) {
            addAtBeginning(id, name, qty, price);
            return;
        }

        ItemNode temp = head;
        for(int i=1; i<pos - 1 && temp.next != null; i++)
            temp = temp.next;

        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Creating a method to remove item by Item ID
    public void removeById(int id) {
        // If list is empty
        if(head == null) {
            System.out.println("Inventory is empty");
            return;
        }

        if(head.itemId == id) {
            head = head.next;
            System.out.println("Item removed");
            return;
        }

        ItemNode temp = head;
        while (temp.next != null && temp.next.itemId != id)
            temp = temp.next;

        if (temp.next == null)
            System.out.println("Item not found");
        else {
            temp.next = temp.next.next;
            System.out.println("Item removed");
        }
    }

    // Creating a method to update quantity of item using Item ID
    public void updateQuantity(int id, int newQty) {
        ItemNode temp = head;

        while(temp != null) {
            if(temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found"); // If item not found in inventory
    }

    // Creating a method to search an item by Item ID
    public void searchById(int id) {
        ItemNode temp = head;

        while(temp != null) {
            if(temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found"); // If item not found in inventory
    }

    // Creating a method to search by Item Name
    public void searchByName(String name) {
        ItemNode temp = head;
        boolean found = false;

        while(temp != null) {
            if(temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }

        if(!found) { // IF item not found
            System.out.println("Item not found");
        }
    }

    // Creating a method to calculate total inventory value
    public void totalInventoryValue() {
        double total = 0;
        ItemNode temp = head;

        while(temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value = " + total);
    }

    // Creating a method to display all items
    public void displayAll() {
        if(head == null) {
            System.out.println("No items in inventory");
            return;
        }

        ItemNode temp = head;
        while(temp != null) {
            displayItem(temp); // Calling the helper method
            temp = temp.next;
        }
    }

    // Creating a helper method to display a single item
    private void displayItem(ItemNode node) {
        System.out.println("ID: " + node.itemId + ", Name: " + node.itemName + ", Qty: " + node.quantity + ", Price: " + node.price);
    }

    // Creating a method to sort by name or price (asc/desc)
    public void sort(int choice, boolean ascending) {
        head = mergeSort(head, choice, ascending);
        System.out.println("Inventory sorted");
    }

    // Creating a method to perform merge sort on linked list
    private ItemNode mergeSort(ItemNode node, int choice, boolean asc) {
        if(node == null || node.next == null)
            return node;

        ItemNode mid = getMiddle(node);
        ItemNode nextToMid = mid.next;
        mid.next = null;

        ItemNode left = mergeSort(node, choice, asc);
        ItemNode right = mergeSort(nextToMid, choice, asc);

        return merge(left, right, choice, asc);
    }

    // Creating a method to merge two sorted lists
    private ItemNode merge(ItemNode a, ItemNode b, int choice, boolean asc) {
        if(a == null) {
            return b;
        }
        if(b == null) {
            return a;
        }

        boolean condition;
        if(choice == 1) { // Sorting by name
            condition = asc ?  a.itemName.compareToIgnoreCase(b.itemName) <= 0 : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else { // Sorting by price
            condition = asc ? a.price <= b.price : a.price > b.price;
        }

        ItemNode result;
        if(condition) {
            result = a;
            result.next = merge(a.next, b, choice, asc);
        } else {
            result = b;
            result.next = merge(a, b.next, choice, asc);
        }
        return result;
    }

    // Creating a method to find middle element of linked list
    private ItemNode getMiddle(ItemNode node) {
        if(node == null) {
            return node;
        }

        ItemNode slow = node, fast = node.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating an object of class inventoryLlist
        InventoryList inventory = new InventoryList();
        int choice;

        do {
            System.out.println("\n1.Add Item at the Beginning");
            System.out.println("2.Add Item at the End");
            System.out.println("3.Add Item at the Position");
            System.out.println("4.Remove Item");
            System.out.println("5.Update Quantity");
            System.out.println("6.Search by ID");
            System.out.println("7.Search by Name");
            System.out.println("8.Total Inventory Value");
            System.out.println("9.Sort");
            System.out.println("10.Display All");
            System.out.println("11.Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Item ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Item Name: ");
                    String name = sc.nextLine();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    if(choice == 1) {
                        inventory.addAtBeginning(id, name, qty, price);
                        System.out.println("Item added at the beginning of the inventory");
                    }
                    else if(choice == 2) {
                        inventory.addAtEnd(id, name, qty, price);
                        System.out.println("Item added at the end of the inventory");
                    }
                    else {
                        System.out.print("Position: ");
                        int pos = sc.nextInt();
                        inventory.addAtPosition(pos, id, name, qty, price);
                        System.out.println("Item added at position: " + pos);
                    }
                    break;

                case 4:
                    System.out.print("Enter Item ID: ");
                    inventory.removeById(sc.nextInt());
                    System.out.println("Item removed successfully");
                    break;

                case 5:
                    System.out.print("Item ID: ");
                    int uid = sc.nextInt();
                    System.out.print("New Quantity: ");
                    inventory.updateQuantity(uid, sc.nextInt());
                    break;

                case 6:
                    System.out.print("Item ID: ");
                    inventory.searchById(sc.nextInt());
                    break;

                case 7:
                    sc.nextLine();
                    System.out.print("Item Name: ");
                    inventory.searchByName(sc.nextLine());
                    break;

                case 8:
                    inventory.totalInventoryValue();
                    break;

                case 9:
                    System.out.println("1.Sort by Name\n2.Sort by Price");
                    int sortChoice = sc.nextInt();
                    System.out.print("Ascending? (true/false): ");
                    boolean asc = sc.nextBoolean();
                    inventory.sort(sortChoice, asc);
                    break;

                case 10:
                    inventory.displayAll();
                    break;

                case 11:
                    System.out.println("Exited");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while(choice != 11);
    }
}

