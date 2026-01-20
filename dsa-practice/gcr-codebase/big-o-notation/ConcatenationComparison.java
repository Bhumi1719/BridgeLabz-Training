import java.util.*;

public class ConcatenationComparison {
    
    public static void main(String[] args) {
        final int[] SIZES = {1000, 10000, 100000};
        Random rand = new Random();

        for(int n : SIZES) {
            String[] strings = new String[n];
            
            for(int i=0; i<n; i++) {
                strings[i] = "Str" + rand.nextInt(n);
            }

            // Using String for concatenation
            long startRB = System.nanoTime();
            String result = "";

            for(String s : strings) {
                result += s;
            }
            long endRB = System.nanoTime();

            // Using StringBuilder
            long startSB = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for(String s : strings) {
                sb.append(s);
            }
            String resultSB = sb.toString();
            long endSB = System.nanoTime();

            // Using String Buffer Concatenation
            long startBuffer = System.nanoTime();
            StringBuffer stringBuffer = new StringBuffer();
            for(String s : strings) {
                stringBuffer.append(s);
            }
            String resultStringBuilder = stringBuffer.toString();
            long endBuffer = System.nanoTime();

            System.out.println("Dataset Size: " + n);
            System.out.println("String Concatenation Time (ns): " + (endRB - startRB));
            System.out.println("StringBuilder Time (ns): " + (endSB - startSB));
            System.out.println("StringBuffer Concatenation Time (ns): " + (endBuffer - startBuffer));
            System.out.println();
        }

        //Comparing the result now
        System.out.println("\nExpected Result:");
        System.out.println("StringBuilder & StringBuffer are much more efficient than String.");
        System.out.println("Use StringBuilder for single-threaded operations and StringBuffer for multi-threaded.");
    }
}
