import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CheckedException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = sc.nextLine(); 

        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);

            while(fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }

            fileScanner.close();
        } catch (IOException e) {
            System.out.println("File not found");
        } finally {
            sc.close();
        }
    }
}
