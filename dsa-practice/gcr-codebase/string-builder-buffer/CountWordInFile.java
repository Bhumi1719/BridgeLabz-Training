import java.io.*;
import java.util.Scanner;

public class CountWordInFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file path: ");
        String path = sc.nextLine();

        System.out.print("Enter word to search: ");
        String target = sc.nextLine();

        int count = 0;

        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for(String w : words) {
                    if(w.equals(target)) {
                        count++;
                    }
                }
            }

            System.out.println("Word '" + target + "' occurred: " + count + " times.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
