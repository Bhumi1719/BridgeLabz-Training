import java.util.*;

public class PrintShopScheduler {

    public static void main(String[] args) throws InterruptedException {

        List<Thread> jobs = new ArrayList<>();

        // Creating print jobs
        jobs.add(new Thread(new PrintJob("Job1", 10, 5), "Job1-Thread"));
        jobs.add(new Thread(new PrintJob("Job2", 5, 8), "Job2-Thread"));
        jobs.add(new Thread(new PrintJob("Job3", 15, 3), "Job3-Thread"));
        jobs.add(new Thread(new PrintJob("Job4", 8, 6), "Job4-Thread"));
        jobs.add(new Thread(new PrintJob("Job5", 12, 7), "Job5-Thread"));

        // Set priorities
        jobs.get(0).setPriority(5);
        jobs.get(1).setPriority(8);
        jobs.get(2).setPriority(3);
        jobs.get(3).setPriority(6);
        jobs.get(4).setPriority(7);

        long startTime = System.currentTimeMillis();

        System.out.println("Starting print jobs...\n");

        // Starting all jobs
        for(Thread t : jobs) {
            t.start();
        }

        // Waiting for all jobs
        for(Thread t : jobs) {
            t.join();
        }

        long totalTime = System.currentTimeMillis() - startTime;

        System.out.println("\nAll jobs completed in " + totalTime + " ms");
    }
}