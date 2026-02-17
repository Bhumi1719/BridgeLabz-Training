import java.util.*;

public class CourierShiftScheduler {

    private List<Employee> staffList = new ArrayList<>();
    private Map<ShiftTime, List<Employee>> shiftMap = new HashMap<>();

    public CourierShiftScheduler() {
        // Initialize shift map
        for(ShiftTime shift : ShiftTime.values()) {
            shiftMap.put(shift, new ArrayList<>());
        }
    }

    public void addEmployee(Employee employee) {
        staffList.add(employee);
    }

    public void assignShift(Employee employee, ShiftTime shift) 
            throws ShiftAlreadyAssignedException {

        // Checking if employee already assigned to any shift
        for(List<Employee> employees : shiftMap.values()) {
            if(employees.contains(employee)) {
                throw new ShiftAlreadyAssignedException("Employee " + employee.getName() + " already assigned to a shift!");
            }
        }

        shiftMap.get(shift).add(employee);
        System.out.println("Shift assigned successfully.");
    }

    public Employee getEmployeeById(int id) {
        for(Employee e : staffList) {
            if(e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public void displayShifts() {
        for(Map.Entry<ShiftTime, List<Employee>> entry : shiftMap.entrySet()) {
            System.out.println(entry.getKey() + " Shift:");
            for(Employee e : entry.getValue()) {
                System.out.println("   " + e);
            }
        }
    }
}

