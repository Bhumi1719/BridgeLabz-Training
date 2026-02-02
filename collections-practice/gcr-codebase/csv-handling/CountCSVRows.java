import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountCSVRows {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Scanner fileScanner = null;

        try {
    
            System.out.print("Enter CSV file path: ");
            String filePath = inputScanner.nextLine();

            File file = new File(filePath);
            fileScanner = new Scanner(file);

            int count = 0;

            // Skipping header row
            if(fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }

            // Counting each remaining line
            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                // Ignoring empty lines
                if(!line.trim().isEmpty()) {
                    count++;
                }
            }

            System.out.println("Number of records (excluding header) are: " + count);

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
