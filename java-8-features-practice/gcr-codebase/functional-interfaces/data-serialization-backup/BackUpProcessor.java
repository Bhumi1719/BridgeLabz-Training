import java.io.*;

public class BackUpProcessor {

    public static void backupObject(Object obj) {
        // Check marker interface
        if(obj instanceof BackUpSerializable) {
            try {
                FileOutputStream file = new FileOutputStream("backup.dat");
                ObjectOutputStream out = new ObjectOutputStream(file);

                out.writeObject(obj);

                out.close();
                file.close();

                System.out.println("Backup successful!");
            } catch (IOException e) {
                System.out.println("Backup failed: " + e.getMessage());
            }
        } else {
            System.out.println("Object is not marked for backup.");
        }
    }
}
