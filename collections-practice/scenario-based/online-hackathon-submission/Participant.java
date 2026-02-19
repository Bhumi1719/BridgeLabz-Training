import java.util.*;

public class Participant {

    private int id;
    private String name;
    private boolean isLate;
    private Map<Integer, Boolean> testCaseResults; 

    public Participant(int id, String name, boolean isLate) throws LateSubmissionException {

        if(isLate) {
            throw new LateSubmissionException("Submission rejected for " + name + " (Late Submission)");
        }

        this.id = id;
        this.name = name;
        this.isLate = isLate;
        this.testCaseResults = new HashMap<>();
    }

    public void addTestResult(int questionId, boolean result) {
        testCaseResults.put(questionId, result);
    }

    public int calculateScore() {
        int score = 0;
        for(boolean result : testCaseResults.values()) {
            if(result) {
                score += 10; 
            }
        }
        return score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return calculateScore();
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Score: " + calculateScore();
    }
}
