public class Agent {
    private int agentId;
    private String location;
    private boolean available = true;

    public Agent(int agentId, String location) {
        this.agentId = agentId;
        this.location = location;
    }

    public int getAgentId() {
        return agentId;
    }

    public String getLocation() {
        return location;
    }

    public boolean isAvailable() {
        return available;
    }

    public void assign() {
        available = false;
    }

    public void free() {
        available = true;
    }

    @Override
    public String toString() {
        return "Agent{id=" + agentId + ", location='" + location + "', available=" + available + "}";
    }
}