public class BackgroundJobExecution {
    public static void main(String[] args) {
        
        // Runnable task using lambda
        Runnable task1 = () -> {
            System.out.println("Task 1 started...");
            try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Task 1 completed!");
        };

        Runnable task2 = () -> {
            System.out.println("Task 2 started...");
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Task 2 completed!");
        };

        // Executing tasks asynchronously
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        System.out.println("Main thread continues executing...");

        // Waiting for threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All background tasks finished.");
    }
}
