import java.io.*;
import java.util.*;

public class CompareMethods {

    // StringBuilder vs StringBuffer
    public static void testStringConcat() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word to concatenate: ");
        String word = sc.nextLine();

        int times = 1_000_000;

        // StringBuilder
        long start1 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<times; i++) {
            sb.append(word);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("StringBuilder Time: " + (end1 - start1) + " ms");

        // StringBuffer
        long start2 = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for(int i=0; i<times; i++) {
            sbf.append(word);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("StringBuffer Time: " + (end2 - start2) + " ms");
    }

    // Method for counting words using FileReader
    public static void readWithFileReader(String filePath) throws Exception {
        long start = System.currentTimeMillis();
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);

        String line;
        long words = 0;
        while ((line = br.readLine()) != null) {
            String[] parts = line.trim().split("\\s+");
            if (!line.trim().isEmpty())
                words += parts.length;
        }
    
        long end = System.currentTimeMillis();
        System.out.println("FileReader Words: " + words);
        System.out.println("FileReader Time: " + (end - start) + " ms");
    }

    // Method for counting words using InputStreamReader
    public static void readWithInputStreamReader(String filePath) throws Exception {
        long start = System.currentTimeMillis();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
        BufferedReader br = new BufferedReader(isr);

        String line;
        long words = 0;

        while ((line = br.readLine()) != null) {
            String[] parts = line.trim().split("\\s+");
            if (!line.trim().isEmpty())
                words += parts.length;
        }

        long end = System.currentTimeMillis();
        System.out.println("InputStreamReader Words: " + words);
        System.out.println("InputStreamReader Time: " + (end - start) + " ms");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Part 1: StringBuilder vs StringBuffer
        testStringConcat();

        // Part 2: File reading comparison
        System.out.print("Enter large file path: ");
        String path = sc.nextLine();

        readWithFileReader(path);
        readWithInputStreamReader(path);
    }
}
