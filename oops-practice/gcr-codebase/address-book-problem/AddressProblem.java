import java.util.*;

public class AddressProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Contacts contact = new Contacts();
		
		System.out.println("Welcome to Address Book Program");
		
		while(true) {
			System.out.println("\n1. Add Contact");
			System.out.println("2. Display Contact");
			System.out.println("3. Exit");
			
			System.out.print("\nEnter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine()
;			
			switch(choice) {
				case 1 : 
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
					
				case 2 :
					contact.displayContact();
					break;
					
				case 3 :
					System.out.print("Enter the first name: ");
					String searchFirstName = sc.nextLine();
					
					System.out.print("Enter the last name: ");
					String searchLastName = sc.nextLine();
					
					contact.editContact(searchFirstName, searchLastName, sc);
					break;
					
				case 4 :
					System.out.println("Exited");
					System.exit(0);
					
				default :
					System.out.println("Enter the valid choice");
			}
				
		}
		
	}

}
