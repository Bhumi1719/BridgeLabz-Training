import java.util.*;

public class DeliveryService {
    private Queue<Order> orderQueue = new LinkedList<>();
    private List<Agent> agents = new ArrayList<>();
    private Map<Order, Agent> activeDeliveries = new HashMap<>();

    public void addOrder(Order order) {
        orderQueue.offer(order);
        System.out.println("Order added successfully.");
    }

    public void addAgent(Agent agent) {
        agents.add(agent);
        System.out.println("Agent added successfully.");
    }

    public void assignOrder() throws NoAgentAvailableException {
        if(orderQueue.isEmpty()) {
            System.out.println("No orders to assign.");
            return;
        }

        Order order = orderQueue.peek();
        Agent nearestAgent = findNearestAvailableAgent(order.getLocation());

        if(nearestAgent == null) {
            throw new NoAgentAvailableException("No delivery agent available!");
        }

        nearestAgent.assign();
        activeDeliveries.put(order, nearestAgent);
        orderQueue.poll();

        System.out.println("Assigned " + order + " to " + nearestAgent);
    }

    private Agent findNearestAvailableAgent(String orderLocation) {
        for(Agent agent : agents) {
            if(agent.isAvailable()) {
                return agent;
            }
        }
        return null;
    }

    public void cancelOrder(int orderId) {
        Order foundOrder = null;

        for(Order order : activeDeliveries.keySet()) {
            if(order.getOrderId() == orderId) {
                foundOrder = order;
                break;
            }
        }

        if(foundOrder != null) {
            Agent agent = activeDeliveries.remove(foundOrder);
            agent.free();
            System.out.println("Order cancelled successfully.");
        } else {
            System.out.println("Order not found in active deliveries.");
        }
    }

    public void viewActiveDeliveries() {
        if(activeDeliveries.isEmpty()) {
            System.out.println("No active deliveries.");
            return;
        }

        for(Map.Entry<Order, Agent> entry : activeDeliveries.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}