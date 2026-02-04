import java.util.*;

public class DisplayingPatientId {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Patient> patients = new ArrayList<>();

        System.out.print("Enter number of patients: ");
        int patient = sc.nextInt();

        for(int i=0; i<patient; i++) {
            System.out.print("\nEnter Patient ID " + (i + 1) + ": ");
            int id = sc.nextInt();

            patients.add(new Patient(id));
        }

        System.out.println("\nPatient IDs:");
        // USing method reference instead of lamda expressions
        patients.stream().map(Patient::getId).forEach(System.out::println); 

    }
}