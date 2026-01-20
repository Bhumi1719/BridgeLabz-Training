public class History {
    Node current;

    public void visit(String url) {
        Node newNode = new Node(url);

        if(current != null) {
            current.next = newNode;
            newNode.prev = current;
        }

        current = newNode;
        System.out.println("Visited: " + url);
    }

    public void back() {
        if(current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Back to: " + current.url);
        } else {
            System.out.println("No previous page.");
        }
    }

    public void forward() {
        if(current != null && current.next != null) {
            current = current.next;
            System.out.println("Forward to: " + current.url);
        } else {
            System.out.println("No next page.");
        }
    }

    public String closeTab() {
        if(current == null) {
            return null;
        }

        String closed = current.url;
        current = current.prev;

        if(current != null) {
            current.next = null;
        }

        return closed;
    }

    public void showCurrent() {
        if(current == null) {
            System.out.println("No page open.");
        } else {
            System.out.println("Current Page: " + current.url);
        }
    }
}
