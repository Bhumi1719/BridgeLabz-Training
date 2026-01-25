import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter source file path: ");
        String sourceFile = sc.nextLine();

        System.out.print("Enter destination file path: ");
        String destinationFile = sc.nextLine();

        File src = new File(sourceFile);

        if(!src.exists()) {
            System.out.println("Source file does not exist: " + sourceFile);
            return;
        }

        try(FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(destinationFile)) {

            byte[] buffer = new byte[1024]; 
            int bytesRead;

            while((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully to " + destinationFile);

        } catch(IOException e) {
            System.out.println("An error occurred during file handling.");
            e.printStackTrace();
        }
    }
}
