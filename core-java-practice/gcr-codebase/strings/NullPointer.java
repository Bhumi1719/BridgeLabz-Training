public class NullPointer {

    public static void main(String[] args) {

        // Calling method to generate the exception (run once, then comment)
        System.out.println("Generating NullPointerException: ");
        generateException();

        // Calling method to handle the exception
        System.out.println("\nHandling NullPointerException: ");
        handleException();
    }

    // Method for generating NullPointerException
    static void generateException() {
        String name = null; // variable initialized to null
        System.out.println(name.length()); // This will throw null pointer exception
    }

    // Method for handling the Exception
    public static void handleException() {
        String name = null;
        try {
            System.out.println(name.length()); // This will throw the exception
        } catch (NullPointerException e) {
            System.out.println("NullPointerException is caught"); // If an exception is thrown it will display this
        }
    }
}
