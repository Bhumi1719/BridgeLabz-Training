import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteCSVFile {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileWriter writer = null;

        try {
    
            System.out.print("Enter CSV file path to create: ");
            String filePath = sc.nextLine();

            File file = new File(filePath);
            writer = new FileWriter(file);

            // Write header line
            writer.append("ID,Name,Department,Salary\n");

            for(int i=1; i<=5; i++) {
                System.out.println("Enter details for Employee " + i + ":");

                System.out.print("ID: ");
                String id = sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Department: ");
                String dept = sc.nextLine();

                System.out.print("Salary: ");
                String salary = sc.nextLine();

                // Writing record to CSV
                writer.append(id).append(",")
                      .append(name).append(",")
                      .append(dept).append(",")
                      .append(salary).append("\n");

                System.out.println("Employee " + i + " added successfully!\n");
            }

            System.out.println("CSV file created successfully at: " + filePath);

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        } finally {
            try {
                if(writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            sc.close();
        }
    }
}


