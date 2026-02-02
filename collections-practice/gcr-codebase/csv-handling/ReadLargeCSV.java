import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadLargeCSV {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Scanner fileScanner = null;

        try {
            
            System.out.print("Enter CSV file path: ");
            String filePath = inputScanner.nextLine();

            File file = new File(filePath);
            fileScanner = new Scanner(file);

            if(fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }

            final int CHUNK_SIZE = 100; // For processing 100 lines at a time
            int totalProcessed = 0;
            int chunkCount = 0;

            while(fileScanner.hasNextLine()) {
                int currentChunk = 0;

                while(fileScanner.hasNextLine() && currentChunk < CHUNK_SIZE) {
                    String line = fileScanner.nextLine();
                    
                    if(line.trim().isEmpty()) {
                        continue;
                    }

                    currentChunk++;
                    totalProcessed++;
                }

                chunkCount++;
                System.out.println("Processed chunk " + chunkCount + " (Total records processed: " + totalProcessed + ")");
            }

            System.out.println("\nFinished processing CSV. Total records: " + totalProcessed);

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
