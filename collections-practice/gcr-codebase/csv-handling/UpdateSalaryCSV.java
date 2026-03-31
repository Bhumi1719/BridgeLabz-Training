import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdateSalaryCSV {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Scanner fileScanner = null;
        FileWriter writer = null;

        try {
            
            System.out.print("Enter input CSV file path: ");
            String inputFilePath = inputScanner.nextLine();

            System.out.print("Enter output CSV file path: ");
            String outputFilePath = inputScanner.nextLine();

            File inputFile = new File(inputFilePath);
            fileScanner = new Scanner(inputFile);

            List<String[]> records = new ArrayList<>();

            String header = "";
            if(fileScanner.hasNextLine()) {
                header = fileScanner.nextLine();
            }

            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.trim().isEmpty()) continue;

                String[] data = line.split(",");

                // Updating salary if department is IT
                if(data[2].equalsIgnoreCase("IT")) {
                    try {
                        double salary = Double.parseDouble(data[3]);
                        salary = salary + (salary * 0.10); // Increasing by 10%
                        data[3] = String.format("%.2f", salary);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid salary format for employee ID " + data[0]);
                    }
                }
                records.add(data);
            }

            // Writing updated records to new CSV
            writer = new FileWriter(outputFilePath);
            writer.append(header).append("\n");

            for(String[] record : records) {
                writer.append(String.join(",", record)).append("\n");
            }

            System.out.println("Updated CSV file created successfully at: " + outputFilePath);

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error writing to output file: " + e.getMessage());
        } finally {
            try { 

                if(fileScanner != null) {
                    fileScanner.close();
                }

                if(writer != null) {
                    writer.close();
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }
            inputScanner.close();
        }
    }
}
