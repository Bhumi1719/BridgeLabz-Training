import java.io.*;
import java.util.Scanner;

public class BufferedFileCopy {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter source file path: ");
        String sourceFile = sc.nextLine();

        System.out.print("Enter destination file path for UNBUFFERED copy: ");
        String destUnbuffered = sc.nextLine();

        System.out.print("Enter destination file path for BUFFERED copy: ");
        String destBuffered = sc.nextLine();

        File src = new File(sourceFile);
        if(!src.exists()) {
            System.out.println("Source file does not exist: " + sourceFile);
            sc.close();
            return;
        }

        // --- Unbuffered Copy ---
        long startTime = System.nanoTime();
        try(FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(destUnbuffered)) {

            byte[] buffer = new byte[4096]; // 4 KB
            int bytesRead;
            while((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch(IOException e) {
            System.out.println("Error during unbuffered copy:");
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        long unbufferedTime = endTime - startTime;
        System.out.println("Unbuffered copy completed in: " + unbufferedTime + " ns");

        // --- Buffered Copy ---
        startTime = System.nanoTime();
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src), 4096);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destBuffered), 4096)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch(IOException e) {
            System.out.println("Error during buffered copy:");
            e.printStackTrace();
        }
        endTime = System.nanoTime();
        long bufferedTime = endTime - startTime;
        System.out.println("Buffered copy completed in: " + bufferedTime + " ns");

        // --- Performance Comparison ---
        System.out.println("\nPerformance Comparison:");
        if(bufferedTime < unbufferedTime) {
            System.out.println("Buffered streams were faster by " + (unbufferedTime - bufferedTime) + " ns");
        } else {
            System.out.println("Unbuffered streams were faster by " + (bufferedTime - unbufferedTime) + " ns");
        }
    }
}

