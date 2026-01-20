public class Parcel {
    ParcelNode head;

    // Create default chain
    public void initDefault() {
        head = new ParcelNode("Packed");
        head.next = new ParcelNode("Shipped");
        head.next.next = new ParcelNode("In Transit");
        head.next.next.next = new ParcelNode("Delivered");
    }

    // Display forward tracking
    public void track() {
        if (head == null) {
            System.out.println("No parcel found (lost).");
            return;
        }
        ParcelNode temp = head;
        while (temp != null) {
            System.out.print(temp.stage);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Add checkpoint after a stage
    public void addCheckpoint(String afterStage, String newStage) {
        ParcelNode temp = head;
        while (temp != null && !temp.stage.equalsIgnoreCase(afterStage)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Stage not found. Parcel may be lost.");
            return;
        }
        ParcelNode node = new ParcelNode(newStage);
        node.next = temp.next;
        temp.next = node;
        System.out.println("Checkpoint added.");
    }

    // Simulate lost parcel
    public void loseParcel() {
        head = null;
        System.out.println("Parcel lost!");
    }
}
