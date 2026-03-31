import java.util.Scanner;

public class FileBackUp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FileBackUpScheduler scheduler = new FileBackUpScheduler();

        try {
            System.out.print("Enter number of backup tasks: ");
            int n = sc.nextInt();
            sc.nextLine(); 

            for(int i=0; i<n; i++) {
                System.out.println("\nEnter details for task " + (i + 1));

                System.out.print("Folder path: ");
                String path = sc.nextLine();

                System.out.print("Priority (1-low, 5-critical): ");
                int priority = sc.nextInt();
                sc.nextLine();

                System.out.print("Backup time: ");
                String time = sc.nextLine();

                scheduler.scheduleBackup(path, priority, time);
            }

        } catch (InvalidBackupPathException e) {
            System.out.println(e.getMessage());
        }

        scheduler.executeBackups();
    }
}
