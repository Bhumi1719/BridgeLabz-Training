import java.time.LocalDate;
import java.util.*;

public class PolicyManager {

    private Map<Integer, Policy> hashMap = new HashMap<>();
    private Map<Integer, Policy> linkedHashMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, Policy> treeMap = new TreeMap<>();

    // Method to add Policy
    public void addPolicy(Policy policy) {
        hashMap.put(policy.getPolicyNumber(), policy);
        linkedHashMap.put(policy.getPolicyNumber(), policy);
        treeMap.put(policy.getExpiryDate(), policy);
    }

    // Method to retrieve policy by number
    public Policy getPolicyByNumber(int policyNumber) {
        return hashMap.get(policyNumber);
    }

    // Method to get policies expiring in next 30 days
    public void getPoliciesExpiringIn30Days() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        for(Map.Entry<LocalDate, Policy> entry : treeMap.entrySet()) {
            if(!entry.getKey().isBefore(today) &&
                !entry.getKey().isAfter(limit)) {
                System.out.println(entry.getValue());
            }
        }
    }

    // Method to get policies by policyholder name
    public void getPoliciesByHolder(String name) {
        for(Policy policy : hashMap.values()) {
            if(policy.getPolicyHolderName().equalsIgnoreCase(name)) {
                System.out.println(policy);
            }
        }
    }

    // Method to remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();

        Iterator<Map.Entry<Integer, Policy>> iterator = hashMap.entrySet().iterator();
        while(iterator.hasNext()) {
            Policy policy = iterator.next().getValue();
            if(policy.getExpiryDate().isBefore(today)) {
                iterator.remove();
                linkedHashMap.remove(policy.getPolicyNumber());
                treeMap.remove(policy.getExpiryDate());
            }
        }
    }
}
