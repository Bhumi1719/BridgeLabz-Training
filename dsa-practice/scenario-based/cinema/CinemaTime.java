import java.util.ArrayList;
import java.util.List;

public class CinemaTime {
    private final List<String> movieTitles;
    private final List<String> showTimes;

    public CinemaTime() {
        movieTitles = new ArrayList<>();
        showTimes = new ArrayList<>();
    }

    private void validateTime(String time) throws InvalidTimeFormatException {
        String[] parts = time.split(":");
        if (parts.length != 2) throw new InvalidTimeFormatException("Invalid time format: " + time);
        try {
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);
            if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
                throw new InvalidTimeFormatException("Invalid time format: " + time);
            }
        } catch (NumberFormatException e) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }
    }

    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        validateTime(time);
        movieTitles.add(title);
        showTimes.add(time);
        System.out.println("Movie added: " + title + " at " + time);
    }

    public void searchMovie(String keyword) {
        boolean found = false;
        for(int i=0; i<movieTitles.size(); i++) {
            if (movieTitles.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(String.format("%d. %s - %s", i + 1, movieTitles.get(i), showTimes.get(i)));
                found = true;
            }
        }
        if(!found) {
            System.out.println("No movies found with keyword: " + keyword);
        }
    }

    public void displayAllMovies() {
        if(movieTitles.isEmpty()) {
            System.out.println("No movies scheduled.");
            return;
        }
        for(int i=0; i<movieTitles.size(); i++) {
            System.out.println(String.format("%d. %s - %s", i + 1, movieTitles.get(i), showTimes.get(i)));
        }
    }

    public String[] getMovieReport() {
        String[] report = new String[movieTitles.size()];
        for(int i=0; i<movieTitles.size(); i++) {
            report[i] = String.format("%s - %s", movieTitles.get(i), showTimes.get(i));
        }
        return report;
    }
}
