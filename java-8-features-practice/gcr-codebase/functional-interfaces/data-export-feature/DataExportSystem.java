import java.util.Scanner;

public class DataExportSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataExporter exporter = new ReportExporter();

        System.out.print("Enter data to export: ");
        String data = sc.nextLine();

        System.out.println("\nSelect export format:");
        System.out.println("1. CSV");
        System.out.println("2. PDF");
        System.out.println("3. JSON");

        System.out.print("\nEnter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                exporter.exportToCSV(data);
                break;
            case 2:
                exporter.exportToPDF(data);
                break;
            case 3:
                exporter.exportToJSON(data); 
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}