import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DetectDuplicateCSV {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Scanner fileScanner = null;

        try {
            
            System.out.print("Enter CSV file path: ");
            String filePath = inputScanner.nextLine();

            File file = new File(filePath);
            fileScanner = new Scanner(file);

            String header = "";
            if(fileScanner.hasNextLine()) {
                header = fileScanner.nextLine();
            }

            Set<String> idSet = new HashSet<>(); // to store unique IDs
            Set<String> duplicates = new HashSet<>(); // to store duplicate IDs

            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                if(line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");
                String id = data[0];

                if(!idSet.add(id)) { 
                    duplicates.add(id);
                }
            }

            if(duplicates.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate records found for ID(s): " + duplicates);

                // Re-reading file to print duplicate rows
                fileScanner.close();
                fileScanner = new Scanner(file);

                if(fileScanner.hasNextLine()) {
                    fileScanner.nextLine(); 
                }

                System.out.println("\nDuplicate Records:");
                System.out.println("-------------------------------");

                while(fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();

                    if(line.trim().isEmpty()) {
                        continue;
                    }

                    String[] data = line.split(",");
                    String id = data[0];

                    if(duplicates.contains(id)) {
                        System.out.println(line);
                    }
                }
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
