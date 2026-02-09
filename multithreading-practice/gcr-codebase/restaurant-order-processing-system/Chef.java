public class Chef extends Thread {

    private String dish;
    private int totalTime;

    public Chef(String chefName, String dish, int totalTime) {
        super(chefName); 
        this.dish = dish;
        this.totalTime = totalTime;
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " started preparing " + dish);

            int stepTime = totalTime / 4; 

            for(int progress=25; progress<=100; progress += 25) {
                Thread.sleep(stepTime);
                System.out.println(getName() + " preparing " + dish + ": " + progress + "% complete");
            }

            System.out.println(getName() + " completed " + dish);

        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted while cooking " + dish);
        }
    }
}