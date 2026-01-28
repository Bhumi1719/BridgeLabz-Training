import java.util.*;

class FileBackUpScheduler {

    PriorityQueue<BackUpTask> queue = new PriorityQueue<>();

    void scheduleBackup(String path, int priority, String time) throws InvalidBackupPathException {

        if(path == null || path.isEmpty() || !path.startsWith("/")) {
            throw new InvalidBackupPathException("Invalid backup path: " + path);
        }

        queue.add(new BackUpTask(path, priority, time));
        System.out.println("Backup scheduled for " + path);
    }

    void executeBackups() {
        System.out.println("\nExecuting backups in priority order:");
        while(!queue.isEmpty()) {
            BackUpTask task = queue.poll();
            task.execute();
        }
    }
}