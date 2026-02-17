public class AreaRequest {
    private String areaName;
    private String resourceType;
    private int quantity;

    public AreaRequest(String areaName, String resourceType, int quantity) {
        this.areaName = areaName;
        this.resourceType = resourceType;
        this.quantity = quantity;
    }

    public String getAreaName() {
        return areaName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Area: " + areaName + ", Resource: " + resourceType + ", Quantity: " + quantity;
    }
}
