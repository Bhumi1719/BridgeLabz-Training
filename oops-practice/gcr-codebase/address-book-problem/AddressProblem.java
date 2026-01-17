import java.util.*;

public class AddressProblem {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Contacts contact = new Contacts();
		
		System.out.println("Welcome to Address Book Program");
		
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
		contact.displayContact();
	}

}
