import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ConsultationScheduler scheduler = new ConsultationScheduler();

        System.out.print("Enter number of doctors: ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<n; i++) {

            System.out.print("Enter Doctor ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Doctor Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Specialization: ");
            String specialization = sc.nextLine();

            Doctor doctor = new Doctor(id, name, specialization);

            System.out.print("Enter number of available slots: ");
            int slotCount = sc.nextInt();
            sc.nextLine();

            for(int j=0; j<slotCount; j++) {
                System.out.print("Enter Slot Time: ");
                String slot = sc.nextLine();
                doctor.addAvailableSlots(slot);
            }

            scheduler.addDoctor(doctor);
        }

        try {
            System.out.print("\nEnter Specialization: ");
            String specialization = sc.nextLine();

            System.out.print("Enter Doctor Name: ");
            String doctorName = sc.nextLine();

            System.out.print("Enter Slot: ");
            String slot = sc.nextLine();

            System.out.print("Enter Patient Name: ");
            String patientName = sc.nextLine();

            scheduler.bookAppointment(specialization, doctorName, slot, patientName);

        } catch (SlotUnavailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
