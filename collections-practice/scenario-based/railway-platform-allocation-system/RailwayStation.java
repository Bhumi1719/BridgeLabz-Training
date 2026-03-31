import java.util.*;

public class RailwayStation {
    private Map<Integer, Platform> platforms = new HashMap<>();
    private PriorityQueue<Train> incomingTrains = new PriorityQueue<>();

    public RailwayStation(int numberOfPlatforms) {
        for(int i=1; i<=numberOfPlatforms; i++) {
            platforms.put(i, new Platform(i));
        }
    }

    public void addTrain(Train train) {
        incomingTrains.add(train);
    }

    public void allocatePlatforms() throws PlatformUnavailableException {
        while(!incomingTrains.isEmpty()) {
            Train train = incomingTrains.poll();
            boolean allocated = false;

            for(Platform platform : platforms.values()) {
                if(platform.isAvailable(train.getArrivalTime())) {
                    platform.assignTrain(train.getDepartureTime());
                    System.out.println("Train " + train.getTrainName() + " allocated to Platform " + platform.getPlatformNumber());
                    allocated = true;
                    break;
                }
            }

            if(!allocated) {
                throw new PlatformUnavailableException("No platform available for train " + train.getTrainName());
            }
        }
    }
}
