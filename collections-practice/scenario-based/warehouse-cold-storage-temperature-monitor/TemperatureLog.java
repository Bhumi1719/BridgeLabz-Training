import java.util.*;

public class TemperatureLog {

    private List<Double> dailyReadings;
    private double minSafeTemp;
    private double maxSafeTemp;

    public TemperatureLog(double minSafeTemp, double maxSafeTemp) {
        this.dailyReadings = new ArrayList<>();
        this.minSafeTemp = minSafeTemp;
        this.maxSafeTemp = maxSafeTemp;
    }

    public void addReading(double temp) throws SensorFailureException {

        if(temp == -999) {  
            throw new SensorFailureException("Sensor Failure Detected!");
        }

        dailyReadings.add(temp);

        if(temp < minSafeTemp || temp > maxSafeTemp) {
            System.out.println("ALERT: Temperature out of safe range!");
        }
    }

    public double calculateAverage() {

        if(dailyReadings.isEmpty())
            return 0;

        double sum = 0;
        for(double temp : dailyReadings) {
            sum += temp;
        }

        return sum / dailyReadings.size();
    }

    public void displayReport() {
        System.out.println("Total Readings: " + dailyReadings.size());
        System.out.println("Average Temperature: " + calculateAverage());
    }
}
