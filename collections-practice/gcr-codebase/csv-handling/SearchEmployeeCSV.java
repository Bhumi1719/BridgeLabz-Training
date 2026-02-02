import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchEmployeeCSV {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Scanner fileScanner = null;

        try {
            
            System.out.print("Enter CSV file path: ");
            String filePath = inputScanner.nextLine();

            File file = new File(filePath);
            fileScanner = new Scanner(file);

            System.out.print("Enter employee name to search: ");
            String searchName = inputScanner.nextLine().trim();

            // Skipping header
            if(fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }

            boolean found = false;

            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                if (line.trim().isEmpty()) {
                    continue; // Skipping empty lines
                }

                String[] data = line.split(",");

                String id = data[0];
                String name = data[1];
                String department = data[2];
                String salary = data[3];

                if(name.equalsIgnoreCase(searchName)) {
                    System.out.println("\nEmployee Found:");
                    System.out.println("-------------------------------");
                    System.out.println("Name       : " + name);
                    System.out.println("Department : " + department);
                    System.out.println("Salary     : " + salary);
                    System.out.println("-------------------------------");
                    found = true;
                    break; 
                }
            }

            if(!found) {
                System.out.println("Employee with name '" + searchName + "' not found.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } finally {
            if(fileScanner != null) {
                fileScanner.close();
            }
            inputScanner.close();
        }
    }
}
