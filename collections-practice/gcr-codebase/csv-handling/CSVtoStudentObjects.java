import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVtoStudentObjects {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Scanner fileScanner = null;

        List<Student> students = new ArrayList<>();

        try {
            
            System.out.print("Enter CSV file path: ");
            String filePath = inputScanner.nextLine();

            File file = new File(filePath);
            fileScanner = new Scanner(file);

            if(fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }

            // Reading each line and creating Student objects
            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine(); 

                if(line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                if(data.length < 4) {
                    continue; // Skipping invalid rows
                }

                try {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    int marks = Integer.parseInt(data[3]);

                    Student student = new Student(id, name, age, marks);
                    students.add(student);
                } catch (NumberFormatException e) {
                    System.out.println("Skipping row due to invalid number: " + line);
                }
            }

            System.out.println("\nList of Students:");
            for(Student s : students) {
                System.out.println(s);
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
