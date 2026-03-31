public class ThreadStateMonitoringSystem {

    public static void main(String[] args) throws InterruptedException {

        TaskRunner t1 = new TaskRunner("Task-1");
        TaskRunner t2 = new TaskRunner("Task-2");

        Thread[] tasks = {t1, t2};

        // Showing NEW state before starting
        System.out.println(t1.getName() + " initial state: " + t1.getState());
        System.out.println(t2.getName() + " initial state: " + t2.getState());
        System.out.println("==================================");

        // Starting monitor first
        StateMonitor monitor = new StateMonitor(tasks);
        monitor.start();

        // Starting tasks
        t1.start();
        t2.start();

        // Waiting for tasks to finish
        t1.join();
        t2.join();

        // Waiting for monitor to finish
        monitor.join();

        System.out.println("\nAll threads completed execution.");
    }
}