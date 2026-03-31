import java.io.*;
import java.util.Scanner;

public class ImageByteArrayCopy {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter source image path: ");
        String sourcePath = sc.nextLine();

        System.out.print("Enter destination image path: ");
        String destPath = sc.nextLine();

        File srcFile = new File(sourcePath);

        if(!srcFile.exists()) {
            System.out.println("Source file does not exist: " + sourcePath);
            sc.close();
            return;
        }

        try(FileInputStream fis = new FileInputStream(srcFile);
            ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096]; // 4KB buffer
            int bytesRead;

            // Read file into ByteArrayOutputStream
            while((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = baos.toByteArray(); // converting to byte array

            // Write byte array back to new file
            try(ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                FileOutputStream fos = new FileOutputStream(destPath)) {

                while((bytesRead = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }

            System.out.println("Image copied successfully to " + destPath);

            // Verification by comparing file sizes
            File destFile = new File(destPath);
            if(srcFile.length() == destFile.length()) {
                System.out.println("Verification: The new file size matches the original.");
            } else {
                System.out.println("Verification: File size mismatch!");
            }

        } catch(IOException e) {
            System.out.println("An error occurred during image processing.");
            e.printStackTrace();
        }
    }
}
