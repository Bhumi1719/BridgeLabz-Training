public class Sensor {
    String sensorName;
    double reading;

    Sensor(String sensorName, double reading) {
        this.sensorName = sensorName;
        this.reading = reading;
    }

    public double getReading() {
        return reading;
    }

    @Override
    public String toString() {
        return sensorName + " | Reading: " + reading;
    }
}
