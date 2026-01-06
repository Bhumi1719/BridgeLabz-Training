import java.util.Scanner;

// Creating an interface named MedicalRecord to manage the records
interface MedicalRecord {
    void addRecord(String diagnosis);
    void viewRecords();
}

// Creating an abstract class named Patient with attributes
abstract class Patient {

    // Creating private attributes(Encapsulated)
    private int patientId;
    private String name;
    private int age;
    private String medicalHistory = "No records";

    // Creating a constructor of the class
    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Creating a getter method for patient id
    public int getPatientId() {
        return patientId;
    }

    // Creating a getter method for patient name
    public String getName() {
        return name;
    }

    // Creating a setter method for medical history
    protected void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    // Creating a method for getting medical history
    protected String getMedicalHistory() {
        return medicalHistory;
    }

    // Creating a concrete method to display the details
    public void getPatientDetails() {
        System.out.println("Patient ID is: " + patientId);
        System.out.println("Name of the patient is: " + name);
        System.out.println("Age of the patient is: " + age);
    }

    // Creating an abstract method to calculate bill
    abstract double calculateBill();
}

// Creating a subclass named InPatient(has medical record)
class InPatient extends Patient implements MedicalRecord {

    private int daysAdmitted;
    private static final double DAILY_CHARGE = 1000;

    // Creating a constructor using the super keyword
    public InPatient(int patientId, String name, int age, int daysAdmitted) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
    }

    // Creating a method to calculate the bill
    @Override
    double calculateBill() {
        return daysAdmitted * DAILY_CHARGE;
    }

    // Creating a method to add a record
    @Override
    public void addRecord(String diagnosis) {
        setMedicalHistory(diagnosis);
    }

    // Creating a method to view the records
    @Override
    public void viewRecords() {
        System.out.println("Medical History: " + getMedicalHistory());
    }
}

// Creating a subclass named OutPatient(has medical record)
class OutPatient extends Patient implements MedicalRecord {

    private static final double CONSULTATION_FEE = 700;

    // Creating a constructor using the super keyword
    public OutPatient(int patientId, String name, int age) {
        super(patientId, name, age);
    }

    // Creating a method to calculate the bill
    @Override
    double calculateBill() {
        return CONSULTATION_FEE;
    }

    // Creating a method to add a record
    @Override
    public void addRecord(String diagnosis) {
        setMedicalHistory(diagnosis);
    }

    // Creating a method to view the records
    @Override
    public void viewRecords() {
        System.out.println("Medical History: " + getMedicalHistory());
    }
}

public class HospitalPatientManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of patients: ");
        int number = sc.nextInt();
        
        sc.nextLine();

        // Creating an array of patients
        Patient[] patients = new Patient[number];

        for(int i=0; i<number; i++) {

        	System.out.println("Hospital Patient Management");
        	System.out.println("1. In-Patient");
        	System.out.println("2. Out-Patient");

        	// Asking the user to enter the choice
        	System.out.print("\nChoose patient type: ");
        	int choice = sc.nextInt();
        
        	sc.nextLine(); // For clearing buffer

        	System.out.print("Enter Patient ID: ");
        	int id = sc.nextInt();
        	sc.nextLine();

        	// Name validation 
        	String name;
        	while(true) {
        		System.out.print("Enter Patient Name (alphabets only): ");
        		name = sc.nextLine();
        		if(name.matches("[a-zA-Z ]+")) {
        			break;
        		} else {
        			System.out.println("Invalid input! Only alphabets allowed.");
        		}
        	}

        	System.out.print("Enter the age of the patient: ");
        	int age = sc.nextInt();
        
        	sc.nextLine();

        	// Switch case for object creation for different choices
        	switch (choice) {
            	case 1:
            		System.out.print("Enter number of days admitted: ");
            		int days = sc.nextInt();
            		sc.nextLine();
            		patients[i] = new InPatient(id, name, age, days);
            		break;

            	case 2:
            		patients[i] = new OutPatient(id, name, age);
            		break;

            	default:
            		System.out.println("Invalid choice!");
            		sc.close();
            		return;
        	}

        	// Adding medical record
        	System.out.print("Enter Diagnosis: ");
        	String diagnosis = sc.nextLine();
        	((MedicalRecord) patients[i]).addRecord(diagnosis);

        	// Condition to check if anything else is entered by user in diagnosis field except alphabets
	        if(!diagnosis.matches("[a-zA-Z ]+")) {
	        	   System.out.println("Invalid diagnosis name! Only alphabets are allowed.");
	        	   i--; // For repeating the iteration
	        	   continue;
	        }
        }

        System.out.println("\n===== Patient Billing Details =====");
        System.out.println();
        for (Patient p : patients) {
            p.getPatientDetails();
            ((MedicalRecord) p).viewRecords();
            System.out.println("Total Bill Amount: INR " + p.calculateBill());
            System.out.println("-----------------------------------");
        }


	}

}
