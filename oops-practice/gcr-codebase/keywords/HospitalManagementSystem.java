// Creating a class named Patient with disfferent types of attributes
class Patient {
    // Creating static variable(shared among all)
    static String hospitalName = "City Hospital";

    // Creating static variable to count total number of patients
    static int TOTAL_PATIENTS = 0;

    // Creating instance variables
    String name;
    int age;
    String ailment;

    // Creating final variable(cannot be changed)
    final String patientID;

    // Creating a constructor of the class
    Patient(String patientID, String name, int age, String ailment) {
        this.patientID = patientID; 
        this.name = name;           
        this.age = age;             
        this.ailment = ailment;    
        TOTAL_PATIENTS++; // incrementing patient count
    }

    // Creating static method to display total number of patients
    static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + TOTAL_PATIENTS);
    }

    // Creating method using instanceof to check object type
    void displayPatientDetails(Object obj) {
        if (obj instanceof Patient) { // Condition to check if obj is an instance of class Patient 
            Patient patient = (Patient) obj; // Type casting

            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + patient.patientID);
            System.out.println("Name: " + patient.name);
            System.out.println("Age: " + patient.age);
            System.out.println("Ailment: " + patient.ailment);
        }
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {

        // Creating an object of the class for patient1
        Patient patient1 = new Patient("P001", "Lathika", 30, "Flu");

        // Creating an object of the class for patient1
        Patient patient2 = new Patient("P002", "Lidiya", 45, "Fracture");

        Patient.getTotalPatients(); // Calling the method to display total number of patients

        patient1.displayPatientDetails(patient1); // Calling the method to display the details of patient1
        patient2.displayPatientDetails(patient2); // Calling the method to display the details of patient1
    }
}