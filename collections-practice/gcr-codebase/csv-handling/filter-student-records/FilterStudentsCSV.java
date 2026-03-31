import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FilterStudentsCSV {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Scanner fileScanner = null;

        try {

            System.out.print("Enter CSV file path: ");
            String filePath = inputScanner.nextLine();

            File file = new File(filePath);
            fileScanner = new Scanner(file);

            // Skipping header row
            if(fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }

            System.out.println("\nStudents with Marks > 80:");
            System.out.println("-------------------------------");

            boolean found = false;

            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                if(line.trim().isEmpty()) {
                    continue; // Skipping empty lines
                }

                String[] data = line.split(",");

                String id = data[0];
                String name = data[1];
                String age = data[2];
                String marksStr = data[3];

                int marks = Integer.parseInt(marksStr);

                if(marks > 80) {
                    System.out.println("ID    : " + id);
                    System.out.println("Name  : " + name);
                    System.out.println("Age   : " + age);
                    System.out.println("Marks : " + marks);
                    System.out.println("-------------------------------");
                    found = true;
                }
            }

            if(!found) {
                System.out.println("No student scored more than 80 marks.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid marks format in CSV: " + e.getMessage());
        } finally {
            if(fileScanner != null) {
                fileScanner.close();
            }
            inputScanner.close();
        }
    }
}
