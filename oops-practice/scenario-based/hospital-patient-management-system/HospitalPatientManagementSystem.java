import java.util.*;

public class HospitalPatientManagementSystem {

    // Creating a list of Patients
    static List<Patient> patients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while(true) {
            System.out.println("\n1.Add Patient");
            System.out.println("2.View Patients");
            System.out.println("3.Update Patient");
            System.out.println("4.Delete Patient");
            System.out.println("5.Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1 :
                    addPatient();
                    System.out.println("Patient Added Successfully");
                    break;
                case 2 :
                    viewPatients();
                    break;
                case 3 :
                    updatePatient();
                    break;
                case 4 :
                    deletePatient();
                    break;
                case 5 :
                    System.exit(0);
                    System.out.println("Thank you for visiting");
                    break;
                default :
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }

    // Creating a method to add Patients
    public static void addPatient() {
        System.out.println("1.InPatient 2.OutPatient");

        System.out.print("Enter the type of patient: ");
        int type = sc.nextInt();

        System.out.print("ID: ");
        int id = sc.nextInt();
        
        System.out.print("Name: ");
        String name;

        // Validating name
        while(true) {
            name = sc.next();
            if(name.matches("[a-zA-Z]+")) {
                break;
            } else {
                System.out.print("Invalid name! Enter alphabets only: ");
            }
        }
        System.out.print("Age: ");
        int age = sc.nextInt();

        // Taking doctor details as input
        System.out.println("\nEnter the details of the doctor for current patient: ");
        System.out.print("Doctor ID: ");
        int dId = sc.nextInt();

        System.out.print("Doctor Name: ");
        String dName;
        while (true) {
            dName = sc.next();
            if (dName.matches("[a-zA-Z]+")) break;
                System.out.print("Enter alphabets only: ");
        }

        System.out.print("Specialization: ");
        String specialization = sc.next();

        Doctor doctor = new Doctor(dId, dName, specialization);

        if(type == 1) {
            System.out.print("\nDays Admitted: ");
            int days = sc.nextInt();
            System.out.print("Daily Charge: ");
            double charge = sc.nextDouble();
            patients.add(new InPatient(id, name, age, doctor, days, charge));
        } else {
            System.out.print("Consultation Fee: ");
            double fee = sc.nextDouble();
            patients.add(new OutPatient(id, name, age, doctor, fee));
        }

    }

    // Creating a method to view patients
    public static void viewPatients() {
        for(Patient patient : patients) {
            patient.displayInfo(); // Calling the method to display the information
            System.out.println("------------------");
        }
    }

    // Creating a method to update the patients
    public static void updatePatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();

        for(Patient patient : patients) {
            if(patient.id == id) {

                System.out.print("New Name: ");
                                
                while(true) {
                    String newName = sc.next();
                    if(newName.matches("[a-zA-Z]+")) {
                        patient.name = newName;
                        break;
                    } else {
                        System.out.print("Invalid name! Enter alphabets only: ");
                    }
                }

                System.out.print("New Age: ");
                patient.age = sc.nextInt();
                System.out.println("Updated Successfully");
                return;
            }
        }
        System.out.println("Patient Not Found");
    }

    // Creating a method to delete Patient
    public static void deletePatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();

        patients.removeIf(p -> p.id == id);
        System.out.println("Deleted Successfully");
    }
}
