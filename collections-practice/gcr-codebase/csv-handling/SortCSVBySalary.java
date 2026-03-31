import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SortCSVBySalary {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Scanner fileScanner = null;

        try {
           
            System.out.print("Enter CSV file path: ");
            String filePath = inputScanner.nextLine();

            File file = new File(filePath);
            fileScanner = new Scanner(file);

            List<String[]> records = new ArrayList<>();

            String header = "";
            if(fileScanner.hasNextLine()) {
                header = fileScanner.nextLine();
            }

            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if(line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");
                records.add(data);
            }

            // Sorting records by Salary (column index 3) in descending order
            records.sort(new Comparator<String[]>() {
                @Override
                public int compare(String[] a, String[] b) {
                    double salaryA = Double.parseDouble(a[3]);
                    double salaryB = Double.parseDouble(b[3]);
                    return Double.compare(salaryB, salaryA); 
                }
            });

            System.out.println("\nTop 5 Highest-Paid Employees:");
            System.out.println("-------------------------------");

            int count = Math.min(5, records.size());

            for(int i=0; i<count; i++) {
                String[] emp = records.get(i);
                System.out.println("ID        : " + emp[0]);
                System.out.println("Name      : " + emp[1]);
                System.out.println("Department: " + emp[2]);
                System.out.println("Salary    : " + emp[3]);
                System.out.println("-------------------------------");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid salary format in CSV: " + e.getMessage());
        } finally {
            if(fileScanner != null) {
                fileScanner.close();
            }
            
            inputScanner.close();
        }
    }
}
