import java.time.ZoneId; // Class for time zone
import java.time.ZonedDateTime; // Class for zone time and date
import java.time.format.DateTimeFormatter; // Class for dateTime formatter

public class TimeZone {
    public static void main(String[] args) {

        // Creating zoneId object for GMT zone
        ZoneId gmtZone = ZoneId.of("GMT"); 
        // Creating zoneId object for IST zone
        ZoneId istZone = ZoneId.of("Asia/Kolkata");
        // Creating zoneId object for PST zone
        ZoneId pstZone = ZoneId.of("America/Los_Angeles");

        // Getting current date and time for GMT
        ZonedDateTime gmtDateTime = ZonedDateTime.now(gmtZone);
        // Getting current date and time for IST
        ZonedDateTime istDateTime = ZonedDateTime.now(istZone);
        // Getting current date and time for PST
        ZonedDateTime pstDateTime = ZonedDateTime.now(pstZone);

        // Creating date formatter object for a particular pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm:ss");

        // Displaying the result for each
        System.out.println("\nGMT Time and Date is: " + gmtDateTime.format(formatter));
        System.out.println("\nIST Time and Date is: " + istDateTime.format(formatter));
        System.out.println("\nPST Time and Date is: " + pstDateTime.format(formatter));
    }
}
