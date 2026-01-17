public class CreateContact {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zip;
	private long phoneNumber;
	private String email;
	
	public CreateContact(String firstName, String lastName, String address, String city, String state, int zip, long phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
    // Creating getter methods
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public int getZip() {
		return zip;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}	

    // Creating setter methods 
	public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	void displayInfo() {
        System.out.println("\n===Contacts List===");
		System.out.println("Name : " + firstName + " " + lastName);
		System.out.println("Address : " + address);
		System.out.println("City : " + city);
		System.out.println("State: " + state);
		System.out.println("Zip code : " + zip);
		System.out.println("Phone number : " + phoneNumber);
		System.out.println("Email : " + email);
	}
}
