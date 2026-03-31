public class PrintJob implements Runnable {

    private String jobName;
    private int pages;
    private int priority;

    public PrintJob(String jobName, int pages, int priority) {
        this.jobName = jobName;
        this.pages = pages;
        this.priority = priority;
    }

    private String getPriorityLabel() {
        if(priority >= 7) {
            return "[High Priority]";
        } else if(priority >= 5) {
            return "[Medium Priority]";
        } else {
            return "[Low Priority]";
        }
    }

    @Override
    public void run() {
        try {
            for(int i=1; i<=pages; i++) {
                System.out.println(getPriorityLabel() + " Printing " + jobName + " - Page " + i + " of " + pages + " (Thread: " + Thread.currentThread().getName() + ")");
                
                Thread.sleep(100); 
            }

            System.out.println(jobName + " completed at " + System.currentTimeMillis());

        } catch (InterruptedException e) {
            System.out.println(jobName + " was interrupted.");
        }
    }
}