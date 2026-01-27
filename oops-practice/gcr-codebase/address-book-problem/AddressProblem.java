import java.util.*;

public class AddressProblem {

	static Scanner sc = new Scanner(System.in);
	static Map<String, Contacts> addressBooks = new HashMap<>();
	public static void main(String[] args) {
		
		System.out.println("Welcome to Address Book Program");
		
		while(true) {
			System.out.println("\n1. Add Address Book");
			System.out.println("2. Add Contact");
			System.out.println("3. Display Contact");
			System.out.println("4. Edit Contact");
			System.out.println("5. Delete Contact");
			System.out.println("6. Exit");
			
			System.out.print("\nEnter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch(choice) {
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
					
				case 3 :
					contact = getAddressBook();
                    if(contact != null) {
                        contact.displayContact();
                    }
                    break;
					
				case 4 :
					contact = getAddressBook();
                    if (contact == null) break;

					System.out.print("Enter the first name: ");
					String searchFirstName = sc.nextLine();
					
					System.out.print("Enter the last name: ");
					String searchLastName = sc.nextLine();
					
					contact.editContact(searchFirstName, searchLastName, sc);
					break;
					
				case 5 :
					contact = getAddressBook();
                    if (contact == null) break;

					System.out.print("Enter the fisrt name: ");
					searchFirstName = sc.nextLine();
					
					System.out.print("Enter the last name: ");
					searchLastName = sc.nextLine();
					
					contact.deleteContact(searchFirstName, searchLastName);
					break;
					
				case 6 :
					System.out.println("Exited");
					System.exit(0);
					
				default :
					System.out.println("Enter the valid choice");
			}
				
		}
		
	}

	private static Contacts getAddressBook() {
        System.out.print("Enter Address Book Name: ");
        String name = sc.nextLine();

        Contacts contact = addressBooks.get(name);
        if(contact == null) {
            System.out.println("Address Book not found");
        }
        return contact;
    }

}
