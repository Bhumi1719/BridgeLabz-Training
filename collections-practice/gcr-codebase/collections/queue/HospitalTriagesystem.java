import java.util.PriorityQueue;
import java.util.Scanner;

class Patient implements Comparable<Patient> {
    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    // Higher severity = higher priority
    @Override
    public int compareTo(Patient p) {
        return p.severity - this.severity;
    }
}

public class HospitalTriagesystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Patient> pq = new PriorityQueue<>();

        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            System.out.print("Enter the patient name: ");
            String name = sc.next();

            System.out.print("Enter severity (higher means more serious): ");
            int severity = sc.nextInt();

            pq.add(new Patient(name, severity));
        }

        System.out.println("\nTreatment Order:");
        while(!pq.isEmpty()) {
            Patient p = pq.poll();
            System.out.println(p.name + " (Severity: " + p.severity + ")");
        }
    }
}
