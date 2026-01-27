import java.util.*;

public class Contacts {
	private ArrayList<CreateContact> contacts;
	
	public Contacts() {
		contacts = new ArrayList<>();
	}
	
	// UC-1/UC-7: Add Contact with Duplicate Check
    void addContact(CreateContact contact) {

        if(contacts.contains(contact)) {
            System.out.println("Duplicate Contact Found. \nCannot Add.");
            return;
        }

        contacts.add(contact);
        System.out.println("Contact Added Successfully");
    }
	
	// UC-2: Display Contacts
	void displayContact() {
		if(contacts.isEmpty()) {
			System.out.println("No contacts found");
		} 
		
		for(CreateContact contact : contacts) {
			contact.displayInfo();
		}
		
	}
	
	// UC-3: Edit Contact
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

	// UC-4: Delete Contact
	void deleteContact(String firstName, String lastName) {
		boolean found = false;
		
		for(int i=0; i<contacts.size(); i++) {
			CreateContact c = contacts.get(i);
			if(c.getFirstName().equalsIgnoreCase(firstName) && c.getLastName().equalsIgnoreCase(lastName)) {
				contacts.remove(i);
				found = true;
			}
		}
		if(found) {
			System.out.print("Contact deleted successfully");
		} else {
			System.out.println("Contact not found");
		}
	}

	// UC-8: Search by City
    List<CreateContact> getContactsByCity(String city) {
        List<CreateContact> result = new ArrayList<>();

        for(CreateContact c : contacts) {
            if(c.getCity().equalsIgnoreCase(city)) {
                result.add(c);
            }
        }
        return result;
    }

    // UC-8: Search by State
    List<CreateContact> getContactsByState(String state) {
        List<CreateContact> result = new ArrayList<>();

        for(CreateContact c : contacts) {
            if(c.getState().equalsIgnoreCase(state)) {
                result.add(c);
            }
        }
        return result;
    }

	// Uc-9: Get All Contacts
	List<CreateContact> getAllContacts() {
		return new ArrayList<>(contacts); 
	}

}
