import java.util.*;

public class SmartEnergyMonitor {

    private Map<Date, List<Double>> usageMap = new HashMap<>();

    public void addReading(EnergyUsage usage) throws InvalidEnergyReadingException {

        if(usage.getValue() <= 0) {
            throw new InvalidEnergyReadingException("Energy reading must be positive.");
        }

        usageMap.computeIfAbsent(usage.getDate(), d -> new ArrayList<>()).add(usage.getValue());
    }

    public double calculateDailyAverage(Date date) {

        List<Double> readings = usageMap.get(date);

        if(readings == null || readings.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for(double r : readings) {
            sum += r;
        }

        return sum / readings.size();
    }

    public double calculateMonthlyAverage(int month, int year) {

        double total = 0;
        int count = 0;

        Calendar cal = Calendar.getInstance();

        for(Map.Entry<Date, List<Double>> entry : usageMap.entrySet()) {

            cal.setTime(entry.getKey());

            if(cal.get(Calendar.MONTH) == month &&
                cal.get(Calendar.YEAR) == year) {

                for(double r : entry.getValue()) {
                    total += r;
                    count++;
                }
            }
        }
        return count == 0 ? 0 : total / count;
    }

    public void generateReport() {
        System.out.println("\nEnergy Usage Report");
        for(Date date : usageMap.keySet()) {
            System.out.println(date + " -> Avg: " + calculateDailyAverage(date) + " kWh");
        }
    }
}
