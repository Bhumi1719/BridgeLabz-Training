import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UppercaseToLowercase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter source file path: ");
        String sourcePath = sc.nextLine();

        System.out.print("Enter destination file path: ");
        String destinationPath = sc.nextLine();

        File sourceFile = new File(sourcePath);

        if(!sourceFile.exists()) {
            System.out.println("Source file does not exist: " + sourcePath);
            sc.close();
            return;
        }

        try(
            FileReader fr = new FileReader(sourceFile, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(destinationPath, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(fw)
        ) {
            String line;

            while((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }

            System.out.println("File converted successfully and saved to: " + destinationPath);

        } catch(IOException e) {
            System.out.println("An error occurred during file processing.");
            e.printStackTrace();
        }
    }
}
