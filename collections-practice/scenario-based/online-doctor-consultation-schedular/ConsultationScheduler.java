import java.util.*;

public class ConsultationScheduler {

    private Map<String, List<Doctor>> doctorMap;

    public ConsultationScheduler() {
        doctorMap = new HashMap<>();
    }

    public void addDoctor(Doctor doctor) {
        doctorMap.computeIfAbsent(doctor.getSpecialization(), k -> new ArrayList<>()).add(doctor);
    }

    public void bookAppointment(String specialization, String doctorName, String slot, String patientName) throws SlotUnavailableException {

        List<Doctor> doctors = doctorMap.get(specialization);

        if(doctors == null) {
            System.out.println("No doctors available for this specialization.");
            return;
        }

        for(Doctor doctor : doctors) {
            if(doctor.getName().equalsIgnoreCase(doctorName)) {
                doctor.bookSlot(slot, patientName);
                System.out.println("Appointment booked successfully!");
                return;
            }
        }

        System.out.println("Doctor not found.");
    }

    public void displayAllDoctors() {
        for(Map.Entry<String, List<Doctor>> entry : doctorMap.entrySet()) {
            System.out.println("\nSpecialization: " + entry.getKey());
            for(Doctor d : entry.getValue()) {
                System.out.println(d);
            }
        }
    }
}
