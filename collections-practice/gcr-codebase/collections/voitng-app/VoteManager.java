import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class VoteManager {

    private Map<String, Integer> voteCountMap = new HashMap<>();
    private Map<Integer, String> voteOrderMap = new LinkedHashMap<>();

    private int voteNumber = 1;

    // Method for casting a vote
    public void castVote(String candidate) {
        voteCountMap.put(candidate, voteCountMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(voteNumber++, candidate);
    }

    // Method to display results in sorted order using TreeMap
    public void displaySortedResults() {
        TreeMap<String, Integer> sortedMap = new TreeMap<>(voteCountMap);

        System.out.println("\nElection Results (Sorted by Candidate):");
        for(Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // Method to display vote order
    public void displayVoteOrder() {
        System.out.println("\nVote Casting Order:");
        for(Map.Entry<Integer, String> entry : voteOrderMap.entrySet()) {
            System.out.println("Vote " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
