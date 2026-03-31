import java.io.*;
import java.util.Scanner;

public class UserInputToFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file path to save user info: ");
        String filePath = sc.nextLine();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileWriter writer = new FileWriter(filePath)) {

            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            // Writing to file
            writer.write("Name: " + name + System.lineSeparator());
            writer.write("Age: " + age + System.lineSeparator());
            writer.write("Favorite Programming Language: " + language + System.lineSeparator());

            System.out.println("User information saved successfully to " + filePath);

        } catch(IOException e) {
            System.out.println("An error occurred while reading or writing.");
            e.printStackTrace();
        }
    }
}
