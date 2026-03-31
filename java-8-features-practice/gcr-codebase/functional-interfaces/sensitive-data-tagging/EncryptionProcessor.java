public class EncryptionProcessor {

    public static void processData(Object obj) {

        // Check marker interface
        if(obj instanceof SensitiveData) {
            System.out.println("\nSensitive data detected. Encrypting...");
            System.out.println("Data encrypted successfully!");
        } else {
            System.out.println("\nPublic data. No encryption required.");
        }
    }
}