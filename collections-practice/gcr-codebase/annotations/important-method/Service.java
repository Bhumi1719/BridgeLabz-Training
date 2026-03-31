public class Service {
    @ImportantMethod
    public void saveData() {
        System.out.println("Saving data...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void updateData() {
        System.out.println("Updating data...");
    }

    public void helperMethod() {
        System.out.println("Helper method (not important)");
    }
}
