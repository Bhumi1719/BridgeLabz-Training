import java.util.Random;

public class FileDownloaderRunnable implements Runnable {
    private String fileName;
    private Random random = new Random();

    public FileDownloaderRunnable(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            for(int progress=0; progress<=100; progress += random.nextInt(20) + 10) {

                if(progress > 100) {
                    progress = 100;
                }

                System.out.println("[" + Thread.currentThread().getName() + "] Downloading " + fileName + ": " + progress + "%");
                Thread.sleep(random.nextInt(1000) + 500);
            }
        } catch (InterruptedException e) {
            System.out.println(fileName + " download interrupted");
        }
    }
}