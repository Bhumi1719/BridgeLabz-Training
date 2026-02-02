import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

public class CSVEncryptDecrypt {

    // AES key (for demonstration, in production store securely)
    private static SecretKey secretKey;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Generate AES key
        secretKey = KeyGenerator.getInstance("AES").generateKey();

        System.out.println("Choose option:");
        System.out.println("1. Encrypt and write CSV");
        System.out.println("2. Read and decrypt CSV");

        System.out.print("\nEnter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> encryptCSV(sc);
            case 2 -> decryptCSV(sc);
            default -> System.out.println("Invalid choice");
        }

        sc.close();
    }

    private static void encryptCSV(Scanner sc) {
        try {
            System.out.print("Enter output CSV file path: ");
            String csvFilePath = sc.nextLine();

            String[][] employees = {
                    {"101", "Aryan", "IT", "50000", "aryan@example.com"},
                    {"102", "Bhumika", "HR", "45000", "bhumika@example.com"},
                    {"103", "Rahul", "Finance", "48000", "rahul@example.com"}
            };

            FileWriter writer = new FileWriter(csvFilePath);

            writer.append("Employee ID,Name,Department,Salary,Email\n");

            for(String[] emp : employees) {
                String id = emp[0];
                String name = emp[1];
                String dept = emp[2];
                String encryptedSalary = encrypt(emp[3]);
                String encryptedEmail = encrypt(emp[4]);

                writer.append(id).append(",")
                        .append(name).append(",")
                        .append(dept).append(",")
                        .append(encryptedSalary).append(",")
                        .append(encryptedEmail).append("\n");
            }

            writer.close();
            System.out.println("Encrypted CSV created successfully at: " + csvFilePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void decryptCSV(Scanner sc) {
        try {
            System.out.print("Enter input CSV file path: ");
            String csvFilePath = sc.nextLine();

            Scanner fileScanner = new Scanner(new File(csvFilePath));

            if(fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }

            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(",");

                String id = data[0];
                String name = data[1];
                String dept = data[2];
                String decryptedSalary = decrypt(data[3]);
                String decryptedEmail = decrypt(data[4]);

                System.out.println(id + "," + name + "," + dept + "," + decryptedSalary + "," + decryptedEmail);
            }

            fileScanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // AES encryption
    private static String encrypt(String plainText) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    // AES decryption
    private static String decrypt(String cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decoded = Base64.getDecoder().decode(cipherText);
        byte[] decrypted = cipher.doFinal(decoded);
        return new String(decrypted, StandardCharsets.UTF_8);
    }
}
