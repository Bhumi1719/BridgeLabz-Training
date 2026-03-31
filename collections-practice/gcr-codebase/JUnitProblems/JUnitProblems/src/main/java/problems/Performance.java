package problems;

public class Performance {

    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000); // Time taken 3 seconds for the test to fail
        return "Task Completed";
    }
}
