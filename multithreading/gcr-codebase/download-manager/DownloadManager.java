import java.util.Scanner;

public class DownloadManager {
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 3 file names:");
        String file1 = sc.nextLine();
        String file2 = sc.nextLine();
        String file3 = sc.nextLine();

        FileDownloaderThread t1 = new FileDownloaderThread(file1);
        FileDownloaderThread t2 = new FileDownloaderThread(file2);
        FileDownloaderThread t3 = new FileDownloaderThread(file3);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("All downloads complete (Thread class)!");

        Thread r1 = new Thread(new FileDownloaderRunnable(file1));
        Thread r2 = new Thread(new FileDownloaderRunnable(file2));
        Thread r3 = new Thread(new FileDownloaderRunnable(file3));

        r1.start();
        r2.start();
        r3.start();

        r1.join();
        r2.join();
        r3.join();

        System.out.println("All downloads complete (Runnable interface)!");
    }
}