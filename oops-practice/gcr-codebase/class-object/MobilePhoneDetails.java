// Creating class named MobilePhobe with attributes
class MobilePhone {
	String brand;
	String model;
	double price;
	
	// Creating the constructor of the class MobilePhone
	MobilePhone(String brand, String model, double price) {
		this.brand = brand;
		this.model = model;
		this.price = price;
	}
	
	// Creating the method to display the mobile details
	 void displayDetails() {
	        System.out.println("Brand of mobile : " + brand);
	        System.out.println("Model of mobile : " + model);
	        System.out.println("Price of mobile : " + price);
	        System.out.println("--------------------------------");
	    }
}
public class MobilePhoneDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Creating object of the class to call it for three different mobile phones
		 MobilePhone mobile1 = new MobilePhone("VIVO", "VIVO V29", 15999.0);
		 mobile1.displayDetails();

	     MobilePhone mobile2 = new MobilePhone("ONE PLUS", "ONE PLUS nord4", 39999.0);
	     mobile2.displayDetails();

	     MobilePhone mobile3 = new MobilePhone("APPLE", "iphone pro16", 79999.0);
	     mobile3.displayDetails();

	}

}
