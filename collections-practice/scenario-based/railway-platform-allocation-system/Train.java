public class Train implements Comparable<Train> {
    private String trainName;
    private int arrivalTime;   
    private int departureTime;

    public Train(String trainName, int arrivalTime, int departureTime) {
        this.trainName = trainName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public int getArrivalTime() { return arrivalTime; }
    public int getDepartureTime() { return departureTime; }
    public String getTrainName() { return trainName; }

    @Override
    public int compareTo(Train other) {
        return this.arrivalTime - other.arrivalTime;  
    }
}
