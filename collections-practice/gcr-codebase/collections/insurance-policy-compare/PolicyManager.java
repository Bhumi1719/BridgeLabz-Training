import java.time.LocalDate;
import java.util.*;

public class PolicyManager {

    private Set<Policy> hashSet = new HashSet<>(); // For fast lookup
    private Set<Policy> linkedHashSet = new LinkedHashSet<>(); // For maintaining insertion order
    private Set<Policy> treeSet = new TreeSet<>(); // For sorting by expiry date

    // Method to add policy
    public boolean addPolicy(Policy policy) {
        boolean addedHash = hashSet.add(policy);
        boolean addedLinked = linkedHashSet.add(policy);
        boolean addedTree = treeSet.add(policy);
        return addedHash && addedLinked && addedTree;
    }

    // Method to display all unique policies
    public void displayAllPolicies() {
        System.out.println("\nAll Policies (HashSet):");
        hashSet.forEach(System.out::println);
    }

    // Method to display policies by expiry within next 30 days
    public void displayPoliciesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        System.out.println("\nPolicies Expiring Within 30 Days (TreeSet sorted):");
        for(Policy p : treeSet) {
            if(!p.getExpiryDate().isBefore(today) && !p.getExpiryDate().isAfter(limit)) {
                System.out.println(p);
            }
        }
    }

    // Method to display policies by coverage type
    public void displayPoliciesByCoverage(String type) {
        System.out.println("\nPolicies with coverage: " + type);
        for(Policy p : hashSet) {
            if(p.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }

    // Method to find duplicate policies by policy number
    public void displayDuplicatePolicies(List<Policy> policyList) {
        Set<Integer> seen = new HashSet<>();
        Set<Policy> duplicates = new HashSet<>();

        for(Policy p : policyList) {
            if(!seen.add(p.getPolicyNumber())) {
                duplicates.add(p);
            }
        }

        if(duplicates.isEmpty()) {
            System.out.println("\nNo duplicate policies found.");
        } else {
            System.out.println("\nDuplicate Policies:");
            duplicates.forEach(System.out::println);
        }
    }

    // Method to compare performance of different Set implementations
    public void comparePerformance(Policy policy) {
        long start, end;

        // HashSet add
        start = System.nanoTime();
        hashSet.add(policy);
        end = System.nanoTime();
        System.out.println("HashSet add: " + (end - start) + " ns");

        // LinkedHashSet add
        start = System.nanoTime();
        linkedHashSet.add(policy);
        end = System.nanoTime();
        System.out.println("LinkedHashSet add: " + (end - start) + " ns");

        // TreeSet add
        start = System.nanoTime();
        treeSet.add(policy);
        end = System.nanoTime();
        System.out.println("TreeSet add: " + (end - start) + " ns");
    }
}
