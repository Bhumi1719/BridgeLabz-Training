import java.util.*;

public class Doctor {
    private int id;
    private String drName;
    private String specialization;
    private List<String> availableSlots;
    private List<String> history;
    
    public Doctor(int id, String drName, String specialization) {
        this.id = id;
        this.drName = drName;
        this.specialization = specialization;
        this.availableSlots = new ArrayList<>();
        this.history = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return drName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void addAvailableSlots(String slot) {
        availableSlots.add(slot);
    }

    public void bookSlot(String slot, String patientName) throws SlotUnavailableException{
        if(!availableSlots.contains(slot)) {
            throw new SlotUnavailableException("Slot unavailable");
        }

        availableSlots.remove(slot);
        history.add("Patient " + patientName + " booked for Slot " + slot);
    }

    public void displayHistory() {
        System.out.print("\nConsultation History of Dr. " + drName);
        for(String record : history) {
            System.out.print(record);
        }
    }

    @Override
    public String toString() {
        return "Dr. " + drName + " (" + specialization + ") ";
    }
}
