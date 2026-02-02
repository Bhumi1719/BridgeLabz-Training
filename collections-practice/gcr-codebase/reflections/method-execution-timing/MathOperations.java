public class MathOperations {
    public void add(int a, int b) {
        try { Thread.sleep(100); } catch (InterruptedException ignored) {}
        System.out.println("Sum: " + (a + b));
    }

    public void multiply(int a, int b) {
        try { Thread.sleep(200); } catch (InterruptedException ignored) {}
        System.out.println("Product: " + (a * b));
    }

    public void subtract(int a, int b) {
        try { Thread.sleep(50); } catch (InterruptedException ignored) {}
        System.out.println("Difference: " + (a - b));
    }
}
