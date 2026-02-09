import java.util.*;

public class FeedbackManager {

    private Map<String, List<Integer>> feedbackMap = new HashMap<>();

    public void addRating(String eventId, int rating) throws InvalidRatingException {

        if(rating < 1 || rating > 5) {
            throw new InvalidRatingException("Rating must be between 1 and 5.");
        }

        feedbackMap.computeIfAbsent(eventId, k -> new ArrayList<>()).add(rating);
    }

    public double calculateAverage(String eventId) {

        List<Integer> ratings = feedbackMap.get(eventId);

        if(ratings == null || ratings.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for(int r : ratings) {
            sum += r;
        }

        return (double) sum / ratings.size();
    }

    public void showTopRatedEvents() {

        double maxAvg = 0;
        Map<String, Double> avgMap = new HashMap<>();

        for(String eventId : feedbackMap.keySet()) {
            double avg = calculateAverage(eventId);
            avgMap.put(eventId, avg);
            maxAvg = Math.max(maxAvg, avg);
        }

        System.out.println("\nTop Rated Event(s):");
        for(Map.Entry<String, Double> entry : avgMap.entrySet()) {
            if(entry.getValue() == maxAvg) {
                System.out.println("Event ID: " + entry.getKey() + " | Avg Rating: " + entry.getValue());
            }
        }
    }

    public void generateReport() {
        System.out.println("\nEvent Rating Report");
        for(String eventId : feedbackMap.keySet()) {
            System.out.println("Event ID: " + eventId + " -> Avg Rating: " + calculateAverage(eventId));
        }
    }
}
