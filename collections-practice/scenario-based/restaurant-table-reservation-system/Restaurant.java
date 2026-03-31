import java.util.*;

public class Restaurant {

    private Map<Integer, Table> tables = new HashMap<>();
    private List<Reservation> reservations = new ArrayList<>();

    // Method to add tables
    public void addTable(Table table) {
        tables.put(table.getTableNumber(), table);
    }

    // Method to reserve table
    public void reserveTable(int tableNumber, String timeSlot, String customerName) throws TableAlreadyReservedException {

        for(Reservation r : reservations) {
            if(r.getTableNumber() == tableNumber && r.getTimeSlot().equalsIgnoreCase(timeSlot)) {
                throw new TableAlreadyReservedException("Table " + tableNumber + " is already reserved for " + timeSlot);
            }
        }

        reservations.add(new Reservation(tableNumber, timeSlot, customerName));
        System.out.println("Table reserved successfully");
    }

    // Method to cancel reservation
    public void cancelReservation(int tableNumber, String timeSlot) {
        Iterator<Reservation> iterator = reservations.iterator();

        while(iterator.hasNext()) {
            Reservation r = iterator.next();
            if(r.getTableNumber() == tableNumber && r.getTimeSlot().equalsIgnoreCase(timeSlot)) {
                iterator.remove();
                System.out.println("Reservation cancelled");
                return;
            }
        }
        System.out.println("Reservation not found");
    }

    // Method to show available tables
    public void showAvailableTables(String timeSlot) {
        System.out.println("Available tables for " + timeSlot + ":");

        for(Table table : tables.values()) {
            boolean reserved = false;

            for(Reservation r : reservations) {
                if(r.getTableNumber() == table.getTableNumber() && r.getTimeSlot().equalsIgnoreCase(timeSlot)) {
                    reserved = true;
                    break;
                }
            }

            if(!reserved) {
                System.out.println("Table " + table.getTableNumber() + " (Capacity: " + table.getCapacity() + ")");
            }
        }
    }
}
