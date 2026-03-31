package problems;

import org.json.JSONObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class MergeJSONFiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter path of first JSON file: ");
        String file1Path = sc.nextLine();

        System.out.print("Enter path of second JSON file: ");
        String file2Path = sc.nextLine();

        try {
            // Reading first JSON file
            String json1Str = readFile(file1Path);
            JSONObject json1 = new JSONObject(json1Str);

            // Reading second JSON file
            String json2Str = readFile(file2Path);
            JSONObject json2 = new JSONObject(json2Str);

            // Merging json2 into json1
            for(Iterator<String> it = json2.keys(); it.hasNext(); ) {
                String key = it.next();
                json1.put(key, json2.get(key)); // overwriting if key exists
            }

            System.out.println("\nMerged JSON:");
            System.out.println(json1.toString());

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error merging JSON files: " + e.getMessage());
        }
    }

    // Helper method to read file content as a String
    private static String readFile(String filePath) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(filePath));
        StringBuilder content = new StringBuilder();
        while (fileScanner.hasNextLine()) {
            content.append(fileScanner.nextLine());
        }
        fileScanner.close();
        return content.toString();
    }
}

