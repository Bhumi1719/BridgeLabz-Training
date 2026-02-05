import java.util.*;
import java.util.stream.*;

public class HospitalDoctor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Doctor> doctors = new ArrayList<>();

        System.out.print("Enter number of doctors: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for(int i=0; i<n; i++) {
            System.out.println("\nEnter details for Doctor " + (i + 1));

            System.out.print("Doctor Name: ");
            String name = sc.nextLine();

            System.out.print("Specialty: ");
            String specialty = sc.nextLine();

            System.out.print("Available on weekends (true/false): ");
            boolean weekendAvailable = sc.nextBoolean();
            sc.nextLine(); 

            doctors.add(new Doctor(name, specialty, weekendAvailable));
        }

        // Stream operations
        List<Doctor> availableDoctors = doctors.stream()
                .filter(Doctor::isWeekendAvailable) // filtering weekend doctors
                .sorted(Comparator.comparing(Doctor::getSpecialty)) // sorting by specialty
                .collect(Collectors.toList());

        System.out.println("\nDoctors Available on Weekends (Sorted by Specialty):");
        availableDoctors.forEach(System.out::println);
    }
}
