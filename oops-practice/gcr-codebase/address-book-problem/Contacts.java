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
}
