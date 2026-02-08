public class TaskRunner extends Thread {

    public TaskRunner(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            // RUNNABLE 
            for(int i=0; i<5_000_000; i++) {
                double temp = Math.sqrt(i); 
            }

            // TIMED_WAITING
            Thread.sleep(2000);

            // RUNNABLE again
            for(int i=0; i<5_000_000; i++) {
                double temp = Math.sqrt(i);
            }

        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted.");
        }
    }
}
