public class Doctor {
    String name;
    String specialty;
    boolean weekendAvailable;

    Doctor(String name, String specialty, boolean weekendAvailable) {
        this.name = name;
        this.specialty = specialty;
        this.weekendAvailable = weekendAvailable;
    }

    public String getSpecialty() {
        return specialty;
    }

    public boolean isWeekendAvailable() {
        return weekendAvailable;
    }

    @Override
    public String toString() {
        return name + " | Specialty: " + specialty + " | Weekend Available: " + weekendAvailable;
    }
}
