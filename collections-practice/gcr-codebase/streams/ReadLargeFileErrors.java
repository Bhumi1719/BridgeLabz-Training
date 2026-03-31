import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ReadLargeFileErrors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter large file path: ");
        String filePath = sc.nextLine();

        File file = new File(filePath);

        if(!file.exists()) {
            System.out.println("File does not exist: " + filePath);
            return;
        }

        long startTime = System.currentTimeMillis();
        int errorCount = 0;

        try(
            FileReader fr = new FileReader(file, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(fr)
        ) {
            String line;

            while((line = br.readLine()) != null) {
                if(line.toLowerCase().contains("error")) {
                    System.out.println(line);
                    errorCount++;
                }
            }

        } catch(IOException e) {
            System.out.println("Error reading large file.");
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("\nTotal 'error' lines found: " + errorCount);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }
}
