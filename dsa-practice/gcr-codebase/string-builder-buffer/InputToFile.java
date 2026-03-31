import java.io.*;

public class InputToFile {
    public static void main(String[] args) throws Exception {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        FileWriter fw = new FileWriter("output.txt", true); // append mode

        System.out.println("Enter text (type 'exit' to stop):");

        String line;
        while(true) {
            line = br.readLine();

            if(line.equalsIgnoreCase("exit")) {
                break;
            }

            fw.write(line + System.lineSeparator());
        }
        System.out.println("Data written to output.txt");
    }
}
