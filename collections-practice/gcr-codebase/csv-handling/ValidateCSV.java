import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateCSV {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Scanner fileScanner = null;

        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        try {
           
            System.out.print("Enter CSV file path: ");
            String filePath = inputScanner.nextLine();

            File file = new File(filePath);
            fileScanner = new Scanner(file);

            if(fileScanner.hasNextLine()) {
                fileScanner.nextLine(); // skipping header
            }

            boolean hasInvalid = false;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                if(line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");
                if(data.length < 4) {
                    System.out.println("Invalid row (missing columns): " + line);
                    hasInvalid = true;
                    continue;
                }

                String id = data[0];
                String name = data[1];
                String email = data[2];
                String phone = data[3];

                boolean valid = true;

                // Validating email
                if(!emailPattern.matcher(email).matches()) {
                    System.out.println("\nInvalid email for ID " + id + ": " + email);
                    valid = false;
                }

                // Validating phone number
                if(!phonePattern.matcher(phone).matches()) {
                    System.out.println("\nInvalid phone number for ID " + id + ": " + phone);
                    valid = false;
                }

                if(!valid) {
                    hasInvalid = true;
                    System.out.println("Invalid row: " + line);
                    System.out.println("--------------------------");
                }
            }

            if(!hasInvalid) {
                System.out.println("All rows are valid.");
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
