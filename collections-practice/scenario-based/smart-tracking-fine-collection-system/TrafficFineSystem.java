import java.util.*;

public class TrafficFineSystem {

    private Map<String, List<Violation>> violationMap = new HashMap<>();

    public void recordViolation(String vehicleNumber, Violation violation) throws InvalidVehicleException {

        if(vehicleNumber == null || vehicleNumber.isEmpty()) {
            throw new InvalidVehicleException("Invalid Vehicle Number!");
        }

        violationMap.putIfAbsent(vehicleNumber, new ArrayList<>());
        violationMap.get(vehicleNumber).add(violation);
    }

    public double calculateTotalFine(String vehicleNumber) throws InvalidVehicleException {

        if(!violationMap.containsKey(vehicleNumber)) {
            throw new InvalidVehicleException("Vehicle not found!");
        }

        List<Violation> violations = violationMap.get(vehicleNumber);
        double total = 0;

        for(int i=0; i<violations.size(); i++) {
            total += violations.get(i).calculateFine(i);
        }

        return total;
    }

    public void generateMonthlyReport() {
        System.out.println("Monthly Traffic Report");

        for(String vehicle : violationMap.keySet()) {
            try {
                double fine = calculateTotalFine(vehicle);
                System.out.println("Vehicle: " + vehicle + " | Violations: " + violationMap.get(vehicle).size() + " | Total Fine: $" + fine);
            } catch (InvalidVehicleException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
