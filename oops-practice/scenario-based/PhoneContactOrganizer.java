import java.util.*;

// Creating a class for custom Exception
class InvalidPhoneNumberException extends Exception {
	// Creating a constructor using super keyword
	public InvalidPhoneNumberException(String msg) {
		super(msg);
	}
}

// Creating a class named Contact with attributes
class Contact {
	
	// Creating private attributes(Encapsulated)
	private String name;
	private String phone;

	// Creating a constructor of the class
	public Contact(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	// Creating a getter method for name
	public String getName() {
		return name;
	}
	// Creating a getter method for phone
	public String getPhone() {
		return phone;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Phone: " + phone;
	}
}
 
public class PhoneContactOrganizer {
	
	static Scanner sc = new Scanner(System.in);
	
	// Creating a list of contacts
	static ArrayList<Contact> contacts = new ArrayList<>();

	// Creating a method to validate phone number
	public static void validatePhone(String phone) throws InvalidPhoneNumberException {
	    if(!phone.matches("\\d{10}")) { // Condition for validating the phone number
	        throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits");
	    }
	}

	// Creating a method for checking duplicate phone numbers
	public static boolean isDuplicate(String phone) {
	    for(Contact contact : contacts) {
	        if(contact.getPhone().equals(phone)) {
	            return true;
	        }
	    }
	    return false;
	}

	 // Creating a method to add contacts
	 public static void addContact() {
		 
	     try {
	         System.out.print("Enter Name: ");
	         String name = sc.nextLine();
	         System.out.print("Enter Phone Number: ");
	         String phone = sc.nextLine();

	         validatePhone(phone); // Calling the method to check for phone number

	         if(isDuplicate(phone)) { // Calling the method to check for duplicate numbers
	             System.out.println("Duplicate contact not allowed");
	             return;
	         }

	         contacts.add(new Contact(name, phone)); // Calling the method to add a contact
	         System.out.println("Contact added successfully");

	     } catch (InvalidPhoneNumberException e) {
	         System.out.println(e.getMessage());
	     }
	 }

	 // Creating a method to delete the contact
	 public static void deleteContact() {
		 
		 try {
			 System.out.print("Enter phone number to delete: ");
		     String phone = sc.nextLine();

		     validatePhone(phone); // Calling the method to check for phone number
		     
		     Iterator<Contact> it = contacts.iterator();
		     while(it.hasNext()) {
		         if(it.next().getPhone().equals(phone)) {
		             it.remove();
		             System.out.println("Contact deleted");
		             return;
		         }
		     }
		     System.out.println("Contact not found");
		 } catch (InvalidPhoneNumberException e) {
	         System.out.println(e.getMessage());
	     }
	     
	 }

	 // Creating a method to search for a contact number
	 public static void searchContact() {
		 
	     System.out.print("Enter name or phone to search: ");
	     String key = sc.nextLine();

	     for(Contact contact : contacts) {
	         if(contact.getName().toLowerCase().contains(key.toLowerCase()) ||
	             contact.getPhone().contains(key)) {
	             System.out.println(contact);
	             return;
	         }
	     }
	     System.out.println("Contact not found");
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Asking the user to enter the choice
		while (true) { // While loop will execute until 4 is entered
			System.out.println("\nChoices:");
            System.out.println("\n1. Add Contact\n2. Delete Contact\n3. Search Contact\n4. Exit");
            System.out.print("\nEnter the choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1 :
                	addContact();
                	break;
                case 2 :
                	deleteContact();
                	break;
                case 3 :
                	searchContact();
                	break;
                case 4 :
                    System.out.println("Exited successfully");
                    return;                
                default :
                	System.out.println("Invalid choice");
            }
        }
	}

}
