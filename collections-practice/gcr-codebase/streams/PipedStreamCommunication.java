import java.io.*;
import java.util.Scanner;

public class PipedStreamCommunication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter message to send from Writer thread: ");
        String message = sc.nextLine();

        try {
            // Create and connect piped streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            // Create threads
            Thread writerThread = new Thread(new WriterThread(pos, message));
            Thread readerThread = new Thread(new ReaderThread(pis));

            // Start threads
            readerThread.start(); // start reader first to avoid blocking
            writerThread.start();

            // Wait for completion
            writerThread.join();
            readerThread.join();

        } catch(IOException | InterruptedException e) {
            System.out.println("Error in piped stream communication.");
            e.printStackTrace();
        }
    }
}

class WriterThread implements Runnable {

    private final PipedOutputStream pos;
    private final String message;

    public WriterThread(PipedOutputStream pos, String message) {
        this.pos = pos;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            pos.write(message.getBytes());
            pos.flush();
            pos.close(); 
        } catch (IOException e) {
            System.out.println("Writer thread error.");
            e.printStackTrace();
        }
    }
}

class ReaderThread implements Runnable {

    private final PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            int data;
            System.out.print("\nReader thread received: ");
            while ((data = pis.read()) != -1) {
                System.out.print((char) data);
            }
            pis.close();
        } catch (IOException e) {
            System.out.println("Reader thread error.");
            e.printStackTrace();
        }
    }
}
