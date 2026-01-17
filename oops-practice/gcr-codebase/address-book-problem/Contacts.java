import java.util.*;

public class Contacts {
	private ArrayList<CreateContact> contacts;
	
	public Contacts() {
		contacts = new ArrayList<>();
	}
	
	void addContact(CreateContact contact) {
		contacts.add(contact);
		System.out.println("Contact added successfully");
	}
	
	void displayContact() {
		if(contacts.isEmpty()) {
			System.out.println("No contacts found");
		} 
		
		for(CreateContact contact : contacts) {
			contact.displayInfo();
		}
		
	}
	
	void editContact(String firstName, String lastName, Scanner sc) {
		boolean found = false;
		for(int i=0; i<contacts.size(); i++) {
			CreateContact c = contacts.get(i);
			if(c.getFirstName().equalsIgnoreCase(firstName) && c.getLastName().equalsIgnoreCase(lastName)) {
				System.out.print("Enter new address: ");
				c.setAddress(sc.nextLine());
				System.out.print("Enter the new city: ");
				c.setCity(sc.nextLine());
				System.out.print("Enter the new state: ");
				c.setState(sc.nextLine());
				System.out.print("Enter the new zip code: ");
				c.setZip(sc.nextInt());
				System.out.print("Enter the new phoneNumber: ");
				c.setPhoneNumber(sc.nextLong());
				sc.nextLine();
				System.out.print("Enter the email: ");
				c.setEmail(sc.nextLine());
				
				found = true;
			}
		}
		
		if(found) {
			System.out.println("Contact updated successfully");
		} else {
			System.out.println("No contact found");
		}
	}
}
