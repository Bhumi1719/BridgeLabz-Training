import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MergeCSVFiles {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        try {
           
            System.out.print("Enter first CSV file path (students1.csv): ");
            String file1Path = inputScanner.nextLine();

            System.out.print("Enter second CSV file path (students2.csv): ");
            String file2Path = inputScanner.nextLine();

            System.out.print("Enter output CSV file path (merged.csv): ");
            String outputFilePath = inputScanner.nextLine();

            // Reading students1.csv
            Map<String, String[]> studentMap = new HashMap<>(); 
            Scanner sc1 = new Scanner(new File(file1Path));

            if(sc1.hasNextLine()) {
                sc1.nextLine(); // Skipping header
            }

            while(sc1.hasNextLine()) {
                String line = sc1.nextLine();

                if(line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");
                studentMap.put(parts[0], new String[]{parts[1], parts[2]}); 
            }
            sc1.close();

            // Reading students2.csv and merging
            Scanner sc2 = new Scanner(new File(file2Path));

            if(sc2.hasNextLine()) {
                sc2.nextLine(); // Skip header
            }

            FileWriter writer = new FileWriter(outputFilePath);
            writer.append("ID,Name,Age,Marks,Grade\n"); 

            while(sc2.hasNextLine()) {
                String line = sc2.nextLine();

                if(line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(","); 
                String id = parts[0];
                String marks = parts[1];
                String grade = parts[2];

                if(studentMap.containsKey(id)) {
                    String name = studentMap.get(id)[0];
                    String age = studentMap.get(id)[1];
                    writer.append(id).append(",")
                          .append(name).append(",")
                          .append(age).append(",")
                          .append(marks).append(",")
                          .append(grade).append("\n");
                } else {
                    System.out.println("ID " + id + " found in second file but not in first file.");
                }
            }

            sc2.close();
            writer.close();

            System.out.println("Merged CSV created successfully at: " + outputFilePath);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        } finally {
            inputScanner.close();
        }
    }
}
