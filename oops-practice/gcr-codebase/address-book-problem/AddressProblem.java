import java.util.*;

public class AddressProblem {

	static Scanner sc = new Scanner(System.in);
	static Map<String, Contacts> addressBooks = new HashMap<>();
	public static void main(String[] args) {
		
		System.out.println("Welcome to Address Book Program");
		
		// UC-5 and UC-6: Adding multiple Contacts and Address Books
		while(true) {
			System.out.println("\n1. Add Address Book");
			System.out.println("2. Add Contact");
			System.out.println("3. Display Contact");
			System.out.println("4. Edit Contact");
			System.out.println("5. Delete Contact");
			System.out.println("6. Search Contact by City or State");
			System.out.println("7. Exit");
			
			System.out.print("\nEnter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch(choice) {
				// UC-6: Add a new Address Book
				case 1 :
					System.out.print("Enter Address Book Name: ");
                    String bookName = sc.nextLine();

                    if(addressBooks.containsKey(bookName)) {
                        System.out.println("Address Book already exists");
                    } else {
                        addressBooks.put(bookName, new Contacts());
                        System.out.println("Address Book created successfully");
                    }
                    break;

				// UC-1 & UC-4: Add a Contact to a selected Address Book
				case 2 : 
					Contacts contact = getAddressBook();
                    if(contact == null) break;

					System.out.print("Enter the first name: ");
					String firstName = sc.nextLine();
					
					System.out.print("Enter the last name: ");
					String lastName = sc.nextLine();
					
					System.out.print("Enter the address: ");
					String address = sc.nextLine();
					
					System.out.print("Enter the city: ");
					String city = sc.nextLine();
					
					System.out.print("Enter the state: ");
					String state = sc.nextLine();
					
					System.out.print("Enter the zip code: ");
					int zip = sc.nextInt();
					
					System.out.print("Enter the phone number: ");
					long phoneNumber = sc.nextLong();
					sc.nextLine();
					
					System.out.print("Enter the email: ");
					String email = sc.nextLine();
					
					CreateContact contacts = new CreateContact(firstName, lastName, address, city, state, zip, phoneNumber, email);
					
					contact.addContact(contacts);
					break;
					
				// UC-2 / UC-4: Display all contacts in selected Address Book
				case 3 :
					contact = getAddressBook();
                    if(contact != null) {
                        contact.displayContact();
                    }
                    break;
				
				// UC-3: Edit existing contact in selected Address Book
				case 4 :
					contact = getAddressBook();
                    if (contact == null) break;

					System.out.print("Enter the first name: ");
					String searchFirstName = sc.nextLine();
					
					System.out.print("Enter the last name: ");
					String searchLastName = sc.nextLine();
					
					contact.editContact(searchFirstName, searchLastName, sc);
					break;
					
				// UC-4: Delete existing contact in selected Address Book
				case 5 :
					contact = getAddressBook();
                    if (contact == null) break;

					System.out.print("Enter the fisrt name: ");
					searchFirstName = sc.nextLine();
					
					System.out.print("Enter the last name: ");
					searchLastName = sc.nextLine();
					
					contact.deleteContact(searchFirstName, searchLastName);
					break;
				
				// UC-8: Search by City/State across multiple Address Books
                case 6:
                    System.out.print("Search by City or State (C/S): ");
                    String csChoice = sc.nextLine();

                    if(csChoice.equalsIgnoreCase("C")) {
                        System.out.print("Enter City Name: ");
                        String cityName = sc.nextLine();
                        searchByCity(cityName);
                    } else if(csChoice.equalsIgnoreCase("S")) {
                        System.out.print("Enter State Name: ");
                        String stateName = sc.nextLine();
                        searchByState(stateName);
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;

				case 7 :
					System.out.println("Exited");
					System.exit(0);
					
				default :
					System.out.println("Enter the valid choice");
			}
				
		}
		
	}

	// UC-5: Helper method to select Address Book
	private static Contacts getAddressBook() {
        System.out.print("Enter Address Book Name: ");
        String name = sc.nextLine();

        Contacts contact = addressBooks.get(name);
        if(contact == null) {
            System.out.println("Address Book not found");
        }
        return contact;
    }

	// UC-8: Search by City across all Address Books
    private static void searchByCity(String city) {
        boolean found = false;

        for(Map.Entry<String, Contacts> entry : addressBooks.entrySet()) {
            String bookName = entry.getKey();
            Contacts contacts = entry.getValue();
            List<CreateContact> results = contacts.getContactsByCity(city);

            if(!results.isEmpty()) {
                found = true;
                System.out.println("\nAddress Book: " + bookName);
                for(CreateContact c : results) {
                    c.displayInfo();
                }
            }
        }
        if(!found) {
            System.out.println("No contacts found in city: " + city);
        }
    }

    // UC-8: Search by State across all Address Books
    private static void searchByState(String state) {
        boolean found = false;
        for(Map.Entry<String, Contacts> entry : addressBooks.entrySet()) {
            String bookName = entry.getKey();
            Contacts contacts = entry.getValue();
            List<CreateContact> results = contacts.getContactsByState(state);

            if(!results.isEmpty()) {
                found = true;
                System.out.println("\nAddress Book: " + bookName);
                for(CreateContact c : results) {
                    c.displayInfo();
                }
            }
        }
        if(!found) {
            System.out.println("No contacts found in state: " + state);
        }
    }

}
