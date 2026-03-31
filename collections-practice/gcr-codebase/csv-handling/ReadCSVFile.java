import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadCSVFile {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Scanner sc = null;

        try {

            System.out.print("Enter CSV file path: ");
            String filePath = inputScanner.nextLine();

            File file = new File(filePath);
            sc = new Scanner(file);

            // Skipping the header line
            if(sc.hasNextLine()) {
                sc.nextLine();
            }

            System.out.println("\nStudent Details:");

            // Reading file line by line
            while(sc.hasNextLine()) {
                String line = sc.nextLine();

                // Splitting each line by comma
                String[] data = line.split(",");

                String id = data[0];
                String name = data[1];
                String age = data[2];
                String marks = data[3];

                System.out.println("ID    : " + id);
                System.out.println("Name  : " + name);
                System.out.println("Age   : " + age);
                System.out.println("Marks : " + marks);
                System.out.println("___________________________");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } finally {
            if(sc != null) {
                sc.close();
            }
        }
    }
}
