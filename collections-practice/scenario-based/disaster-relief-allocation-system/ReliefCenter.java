import java.util.*;

public class ReliefCenter {

    private String centerName;
    private HashMap<String, Integer> resources;   
    private Queue<AreaRequest> requestQueue;     
    private List<String> allocationReport;

    public ReliefCenter(String centerName) {
        this.centerName = centerName;
        resources = new HashMap<>();
        requestQueue = new LinkedList<>();
        allocationReport = new ArrayList<>();
    }

    public void addResource(String item, int quantity) {
        resources.put(item, resources.getOrDefault(item, 0) + quantity);
    }

    public void addRequest(AreaRequest request) {
        requestQueue.offer(request); 
    }

    public void allocateResources() throws InsufficientResourceException {

        while(!requestQueue.isEmpty()) {

            AreaRequest request = requestQueue.poll();  
            String item = request.getResourceType();
            int requestedQty = request.getQuantity();

            int availableQty = resources.getOrDefault(item, 0);

            if(availableQty >= requestedQty) {
                resources.put(item, availableQty - requestedQty);

                String successMsg = "Allocated " + requestedQty + " " + item + " to " + request.getAreaName();

                allocationReport.add(successMsg);
            } 
            else {
                throw new InsufficientResourceException("Insufficient " + item + " for " + request.getAreaName());
            }
        }
    }

    public void generateReport() {
        System.out.println("\nAllocation Report for " + centerName);
        for(String record : allocationReport) {
            System.out.println(record);
        }

        System.out.println("\nRemaining Resources:");
        for(Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
