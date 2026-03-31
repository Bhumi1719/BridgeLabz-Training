import java.util.*;

public class CompareStringBufferBuilder {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to concatenate: ");
        String text = sc.nextLine();
        int times = 1_000_000;

        // StringBuilder
        long startBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < times; i++) {
            sb.append(text);
        }
        long endBuilder = System.nanoTime();
        long timeBuilder = endBuilder - startBuilder;

        // StringBuffer
        long startBuffer = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for(int i = 0; i < times; i++) {
            sbf.append(text);
        }
        long endBuffer = System.nanoTime();
        long timeBuffer = endBuffer - startBuffer;

        System.out.println("StringBuilder Time (ns): " + timeBuilder);
        System.out.println("StringBuffer Time (ns): " + timeBuffer);
    }
}
