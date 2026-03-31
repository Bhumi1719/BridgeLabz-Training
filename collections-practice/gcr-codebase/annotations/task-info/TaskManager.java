public class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Ayush")
    public void taskOne() {
        System.out.println("Executing Task One...");
    }

    @TaskInfo(priority = "Medium", assignedTo = "Abhi")
    public void taskTwo() {
        System.out.println("Executing Task Two...");
    }

    @TaskInfo(priority = "Low", assignedTo = "Bhumi")
    public void taskThree() {
        System.out.println("Executing Task Three...");
    }
}
