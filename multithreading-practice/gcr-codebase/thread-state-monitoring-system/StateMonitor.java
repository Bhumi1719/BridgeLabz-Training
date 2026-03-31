import java.util.*;
import java.time.LocalTime;

public class StateMonitor extends Thread {

    private Thread[] threads;
    private Map<String, Set<Thread.State>> stateHistory = new HashMap<>();

    public StateMonitor(Thread[] threads) {
        this.threads = threads;

        for(Thread t : threads) {
            stateHistory.put(t.getName(), new HashSet<>());
        }
    }

    @Override
    public void run() {
        boolean allTerminated = false;

        while(!allTerminated) {
            allTerminated = true;

            for(Thread t : threads) {

                Thread.State state = t.getState();
                stateHistory.get(t.getName()).add(state);

                System.out.println("[Monitor] " + t.getName() + " is in " + state + " state at " + LocalTime.now());

                if(state != Thread.State.TERMINATED) {
                    allTerminated = false;
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Monitor interrupted.");
            }

            System.out.println("----------------------------------");
        }

        // Summary
        System.out.println("\nSUMMARY");
        for(String threadName : stateHistory.keySet()) {
            System.out.println("Summary: " + threadName + " went through " + stateHistory.get(threadName).size() + " states -> " + stateHistory.get(threadName));
        }
    }
}