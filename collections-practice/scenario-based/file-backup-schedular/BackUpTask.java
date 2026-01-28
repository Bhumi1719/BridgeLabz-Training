class BackUpTask implements Comparable<BackUpTask> {
    String folderPath;
    int priority; 
    String time;

    BackUpTask(String folderPath, int priority, String time) {
        this.folderPath = folderPath;
        this.priority = priority;
        this.time = time;
    }

    @Override
    public int compareTo(BackUpTask other) {
        return Integer.compare(other.priority, this.priority);
    }

    void execute() {
        System.out.println(" Backing up folder: " + folderPath + " | Priority: " + priority + " | Time: " + time);
    }
}